package donorsChoose.collections;

import java.util.List;
import java.util.ListIterator;

import donorsChoose.Classes.Donation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class donationCollection implements Serializable{
	
	final String path = System.getProperty("user.home") + "/donorschoose/donations.ser";
	
	List<Donation> donations;
	
	public donationCollection() {
		this.donations=new ArrayList<>();
	}
	
	public boolean addDonation(Donation entered_donation) {
		return donations.add(entered_donation);
	}
	
	public boolean removeDonation(Donation entered_donation) {
		return donations.remove(entered_donation);
	}
	
	public double calculateTotal() {
		double total=0;
		ListIterator<Donation> iter= donations.listIterator();
		while(iter.hasNext()) {
			Donation u = iter.next();	
			total+=u.getAmount();
		}
		return total;
	}
	
	@Override
	public String toString() {
		String str = "";
		ListIterator<Donation> rqst = donations.listIterator();
		while(rqst.hasNext()) {
			Donation U = rqst.next();
			str+= U.toString()+"\n";
		}
		return str;
	}
	
	public void load(String path) throws ClassNotFoundException,IOException {
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream oin = new ObjectInputStream(fin);
		this.donations = (List<Donation>) oin.readObject();
		oin.close();
	}

	public void save(String path) throws IOException {
		File f = new File(path);
		if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
		FileOutputStream fout = new FileOutputStream(path,false);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(this.donations);
		out.close();
	}
}

