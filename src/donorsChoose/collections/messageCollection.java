package donorsChoose.collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import donorsChoose.Classes.Message;

public class messageCollection implements Serializable{

	final String path = System.getProperty("user.home") + "/donorschoose/messages.ser";
	
	List<Message> messages;
	
	public messageCollection() {
		this.messages=new ArrayList<>();
	}
	
	public boolean addMessage(Message entered_message) {
		return messages.add(entered_message);
	}
	
	public boolean removeMessage(Message entered_message) {
		return messages.remove(entered_message);
	}
	
	@Override
	public String toString() {
		String str = "";
		ListIterator<Message> rqst = messages.listIterator();
		while(rqst.hasNext()) {
			Message U = rqst.next();
			str+= U.toString()+"\n";
		}
		return str;
	}
	
	public void load(String path) throws ClassNotFoundException,IOException {
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream oin = new ObjectInputStream(fin);
		this.messages = (List<Message>) oin.readObject();
		oin.close();
	}

	public void save(String path) throws IOException {
		File f = new File(path);
		if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
		FileOutputStream fout = new FileOutputStream(path,false);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(this.messages);
		out.close();
	}
}

