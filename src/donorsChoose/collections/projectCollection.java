package donorsChoose.collections;

import java.util.List;
import java.util.ListIterator;

import donorsChoose.Classes.ProjectRequest;
import donorsChoose.enumerations.Category;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class projectCollection implements Serializable{
	
	String path = System.getProperty("user.home") + "/donorschoose/projects.ser";
	
	List<ProjectRequest> projects;
	
	public projectCollection() {
		this.projects=new ArrayList<>(); //list of projects
	}
	
	public boolean addProject(ProjectRequest proj) {
		return projects.add(proj);
	}
	
	public boolean removeProject(ProjectRequest proj) {
		return projects.remove(proj);
	}
	
	public ArrayList<ProjectRequest> searchProject(String title){ // search projects by category 
		ArrayList<ProjectRequest> results = new ArrayList<>();
		ListIterator<ProjectRequest> iter= projects.listIterator();
		while(iter.hasNext()) {
			ProjectRequest u = iter.next();
			if(u.getTitle().equals(title)) {
				results.add(u);
			}
		}
		return results;
	}
	
	public ProjectRequest findProject(String title, String dateposted) {
		Date date = null;
		try {
		date = new SimpleDateFormat("dd/MM/yyyy").parse(dateposted); // translate the String to Date format
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		ListIterator<ProjectRequest> iter= projects.listIterator();
		while(iter.hasNext()) {
			ProjectRequest u = iter.next();
			if(u.getTitle().equals(title) && u.getdateposted().equals(date)) {
				return u;
			}
		}
			return null;
	}

	
	@Override
	public String toString() {
		String str = "";
		ListIterator<ProjectRequest> rqst = projects.listIterator();
		while(rqst.hasNext()) {
			ProjectRequest U = rqst.next();
			str+= U.toString()+"\n";
		}
		return str;
	}
	
	public void load() throws ClassNotFoundException,IOException {
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream oin = new ObjectInputStream(fin);
		this.projects = (List<ProjectRequest>) oin.readObject();
		oin.close();
	}

	public void save() throws IOException {
		File f = new File(path);
		if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
		FileOutputStream fout = new FileOutputStream(path,false);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(this.projects);
		out.close();
	}
}
