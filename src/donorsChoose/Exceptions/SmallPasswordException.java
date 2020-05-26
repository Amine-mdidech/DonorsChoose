package donorsChoose.Exceptions;

public class SmallPasswordException extends Exception { // Custom Exception of a weak Password
	public SmallPasswordException(){
		super(" The Password is too Weak \n");
	}
}
