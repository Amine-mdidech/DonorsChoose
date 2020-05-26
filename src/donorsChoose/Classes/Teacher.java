package donorsChoose.Classes;

import java.io.Serializable;
import java.util.Date;

import donorsChoose.Classes.Profile;
import donorsChoose.collections.projectCollection;
import donorsChoose.enumerations.project_status;

public class Teacher extends User implements Serializable{ // user is the super class from the CRC cards
	
	public Teacher(Profile pp) { // Constructor and super Constructor
		super(pp);
	};
	
	
	public void Post_Project(String title, String story, String deadline, String dateposted, double goal, double grade, String cat, Teacher t,projectCollection projects) {
		ProjectRequest p = new ProjectRequest(title,story,deadline,dateposted,goal,grade,cat,t);
		projects.addProject(p);
	} 
	
	public void Mark_Project_as_expired(ProjectRequest project) {
		project.setStat(project_status.EXPIRED);
	} // mark project as expired method
	
	public void Post_Thank_You_Note(String L) {
		thank_you_Package thanks = new thank_you_Package(L);
	} // post a thank you note method
	
	@Override
	public String toString() {
		return "\n Teacher Profile \n" + getPp().toString();
	}
	
}
