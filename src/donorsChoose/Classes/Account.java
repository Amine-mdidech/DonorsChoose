package donorsChoose.Classes;

import java.io.Serializable;

import donorsChoose.Exceptions.SmallPasswordException;

public class Account implements Serializable{
	private String email;
	private String password;
	private User u; //Account->User->profile, so by acceding an account you have access to the user, ( teacher or donor ), and have access to the profile
	
	public Account(String email, String password) throws SmallPasswordException { // Custom exception if password is too weak
		this.email=email;
		setpassword(password);
	}
	
	public Account(String email, String password, User u) throws SmallPasswordException { // Custom exception if password is too weak
		this.email=email;
		setpassword(password);
		this.u=u;
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
	
	public void setUser(User u) {
		this.u=u;
	}
	
	public String getemail() {
		return email;
	}
	
	public String getpassword() {
		return password;
	}
	
	public User getUser(){
		return u;
	}
	
	@Override
	public String toString() {
		return "\n "+email+"\n"+u.toString();
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
