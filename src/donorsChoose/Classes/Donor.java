package donorsChoose.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Donor extends User implements Serializable{ // user is the super class from the CRC cards
	
	public Donor(Profile pp) { //Super Constructor
		super(pp);
	};
	
	List<ProjectRequest> wishlist = new ArrayList<>();
	
	public void donor_donate(ProjectRequest r,String d,double amountt) {
		r.Donate(d, amountt);
	}
	
	public void Add_project_to_wishlist(ProjectRequest a) {
		wishlist.add(a);
	} // add a project to a wishlist
	
	public void Remove_project_from_wishlist(ProjectRequest a) {
		wishlist.remove(a);
	}
	
	@Override
	public String toString() {
		return "\n Donor Profile \n" + getPp().toString();
	}
	
}
