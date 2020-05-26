package donorsChoose;

import donorsChoose.Exceptions.SmallPasswordException;

public class Account {
	private String email;
	private String password;
	
	public Account(String email, String password) throws SmallPasswordException { // Custom exception if password is too weak
		this.email=email;
		setpassword(password);
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	public void setpassword(String password) throws SmallPasswordException {
		if(CheckPassword(password)==true) { // CheckPassword method checks if the password is weak
			this.password=password;
		}
		else {
			throw new SmallPasswordException();
		}
	}
	
	public String getemail() {
		return email;
	}
	
	public String getpassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "\n Email : "+ email +"\n Password : "+ password;
	}
	
	private boolean CheckPassword(String password){ // this method checks if the password has less than 5 characters
		if(password.length()<5) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void changepassword() { //change password method
		
	}
	
	public void forgotpassword() {// forgot password method
	
	}
	
	
}
