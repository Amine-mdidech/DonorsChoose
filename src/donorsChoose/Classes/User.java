package donorsChoose.Classes;

import java.io.Serializable;

import donorsChoose.Classes.Profile;
import donorsChoose.Exceptions.GenderException; 

public class User implements Serializable{ // User is a superClass as in the CRC cards, that is linked to profile
	
	private Profile pp;
	
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
	
	public void updateProfile(String F_name, String L_name, String birthdate,String gender, String address) throws GenderException {
		pp.setFname(F_name);
		pp.setLname(L_name);
		pp.setBirthdate(birthdate);
		pp.setgender(gender);
		pp.setAddress(address);
	}
}
