package donorsChoose;

import java.util.Date;

public class Donation {
	private Date date;
	private double amount;
	
	public Donation(double amount) {
		this.amount=amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Date " + date + " Donation Amount " + amount;
	}
	
	
}
