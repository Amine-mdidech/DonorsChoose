package donorsChoose.Exceptions;

import donorsChoose.enumerations.Gender;

public class GenderException extends Exception {
	public GenderException(String gender) {
		super(gender+": is not a valid Gender \n");
	}
	public String[] getAvailableGenders () {
        Gender[] cats = Gender.values();
        String catStrs[]= new String[cats.length];
        for (int i=0; i<cats.length; i++){
            catStrs[i]= cats[i].name();
            System.out.println(catStrs[i]);
        }
        
        return catStrs;
   }

}
