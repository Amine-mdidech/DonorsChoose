package donorsChoose;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import donorsChoose.Exceptions.GenderException;

public class Profile {
	private String F_name;
	private String L_name;
	private Gender gender;
	private Date birthdate;
	private String address;
	
	public Profile(String F_name, String L_name, String birthdate,String gender, String address) throws GenderException{
		this.F_name=F_name;
		this.L_name=L_name;
		setBirthdate(birthdate);
		setgender(gender);
		this.address=address;
	}

	public String getFname() {
		return F_name;
	}

	public void setFname(String F_name) {
		this.F_name = F_name;
	}

	public String getLname() {
		return L_name;
	}

	public void setLname(String L_name) {
		this.L_name = F_name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setgender(String gender) throws GenderException {
		if(gender.equalsIgnoreCase(Gender.MALE.name()) || gender.equalsIgnoreCase(Gender.FEMALE.name())) {
			gender=gender.toUpperCase();
			this.gender=Gender.valueOf(gender);
		}
		else {
			throw new GenderException();
		}
			
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate){
		
		Date date = null;
		
		try {
		date = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate); // translate the String to Date format
		
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		this.birthdate=date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "\n First name: "+F_name+"\n Last name: "+L_name+"\n Gender: "+gender+"\n birthdate: "+birthdate+ "\n address: "+address;
		
	}
	
}
