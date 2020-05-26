package donorsChoose;

import donorsChoose.Profile; 

public class User { // User is a superClass as in the CRC cards, that is linked to profile
	
	Profile pp;
	
	public User(Profile pp) {
		this.pp=pp;
	}
	
	public Profile getPp() {
		return pp;
	}
	
	@Override
	public String toString() {
		return "\n User Profile \n" + pp.toString();
	}
	
	public void updateprofile() { //update profile method
	}
	
}
