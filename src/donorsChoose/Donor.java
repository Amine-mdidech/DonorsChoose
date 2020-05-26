package donorsChoose;

import donorsChoose.Profile;

public class Donor extends User{ // user is the super class from the CRC cards
	
	public Donor(Profile pp) { //Super Constructor
		super(pp);
	};
	
	@Override
	public void updateprofile(){ // inherited From User	
	};
	
	public void Donate() {} // Donate 
	
	public void Add_project_to_wishlist() {} // add a project to a wishlist
	
	@Override
	public String toString() {
		return "\n Donor Profile \n" + pp.toString();
	}
	
}
