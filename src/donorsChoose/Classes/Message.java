package donorsChoose.Classes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Message implements Serializable{
	private Date date;
	private String text;
	private Account a;
	
	public Message(String text,String date,Account a) {
		this.text=text;
		setDate(date);
		this.a=a;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(String date) {
		Date datee = null;
		
		try {
		datee = new SimpleDateFormat("dd/MM/yyyy").parse(date); // translate the String to Date format
		
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		this.date=datee;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Account getA() {
		return a;
	}

	public void setA(Account a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Date of message :" + date + "\nMessage:" + text;
	}

}
