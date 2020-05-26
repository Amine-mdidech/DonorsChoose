package donorsChoose;

import donorsChoose.Profile;

public class Teacher extends User{ // user is the super class from the CRC cards
	
	public Teacher(Profile pp) { // Constructor and super Constructor
		super(pp);
	};
	
	
	
	@Override
	public void updateprofile(){ // inherited From User	
	};
	
	public void Post_Project() {} // post a project method
	
	public void Mark_Project_as_expired() {} // mark project as expired method
	
	public void Post_Thank_You_Note() {} // post a thank you note method
	
	@Override
	public String toString() {
		return "\n Teacher Profile \n" + pp.toString();
	}
	
}
