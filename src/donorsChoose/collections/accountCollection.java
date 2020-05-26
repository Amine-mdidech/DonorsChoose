package donorsChoose.collections;

import java.util.List;
import java.util.ListIterator;

import donorsChoose.Classes.Account;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class accountCollection implements Serializable{
	
	String path = System.getProperty("user.home") + "/donorschoose/accounts.ser";
	
	List<Account> accounts;
	
	public accountCollection() {
		this.accounts=new ArrayList<>(); //list of accounts
	}
	
	public boolean addAccount(Account acc) {
		return accounts.add(acc);
	}
	
	public boolean removeAccount(Account acc) {
		return accounts.remove(acc);
	}
	
	public void modifyAccount(Account acc, Account theacc) { 
		int index= accounts.indexOf(acc);
		if(index >= 0) {
			accounts.set(index,theacc);
		}
	}
	
	public ArrayList<Account> searchAccount(String lname){ // search an account by the last name 
		ArrayList<Account> results = new ArrayList<>();
		ListIterator<Account> iter= accounts.listIterator();
		while(iter.hasNext()) {
			Account u = iter.next();
			if(u.getUser().getPp().getLname().equals(lname)) {
				results.add(u);
			}
		}
		return results;
	}

	public Account searchAccountemailpassword(String e_mail, String password){ // search an account by email and password
		Account result = null;
		ListIterator<Account> iter= accounts.listIterator();
		while(iter.hasNext()) {
			Account u = iter.next();
			if(u.getemail().equals(e_mail) && u.getpassword().equals(password)) {
				result = u;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		String str = "";
		ListIterator<Account> usr = accounts.listIterator();
		while(usr.hasNext()) {
			Account U = usr.next();
			str+= U.toString()+"\n";
		}
		return str;
	}
	
	public void load() throws ClassNotFoundException,IOException {
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream oin = new ObjectInputStream(fin);
		this.accounts = (List<Account>) oin.readObject();
		oin.close();
	}

	public void save() throws IOException {
		File f = new File(path);
		if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
		FileOutputStream fout = new FileOutputStream(path, false);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(this.accounts);
		out.close();
	}
}
