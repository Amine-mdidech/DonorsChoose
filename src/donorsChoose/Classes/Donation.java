package donorsChoose.Classes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Donation implements Serializable{
	private Date date;
	private double amount;
	
	public Donation(double amount,String date) {
		this.amount=amount;
		setdate(date);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getdate() {
		return date;
	}

	public void setdate(String date){
		
		Date datee = null;
		
		try {
		datee = new SimpleDateFormat("dd/MM/yyyy").parse(date); // translate the String to Date format
		
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		this.date=datee;
	}

	@Override
	public String toString() {
		return "Date " + date + " Donation Amount " + amount;
	}
	
	
}
