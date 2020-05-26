package donorsChoose;

import java.util.Calendar;

public class Message {
	private Calendar Date;
	private String text;
	
	public Message(String text) {
		this.text=text;
	}
	
	public Calendar getDate() {
		return Date;
	}

	public void setDate(Calendar date) {
		Date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Date " + Date + " text " + text;
	}

}
