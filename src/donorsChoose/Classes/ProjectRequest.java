package donorsChoose.Classes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import donorsChoose.collections.donationCollection;
import donorsChoose.collections.materialCollection;
import donorsChoose.collections.messageCollection;
import donorsChoose.enumerations.Category;
import donorsChoose.enumerations.project_status;

public class ProjectRequest implements Serializable{
	
	private String title;
	private String story;
	private double goal;
	private double grade;
	private Date deadline;
	private Date dateposted;
	private Category cat;
	
	private project_status stat;
	
	private thank_you_Package thanks;



	private Teacher t; //Teacher 1:1 relationship
	
	donationCollection theDcollection = new donationCollection();
	messageCollection theMcollection = new messageCollection();
	materialCollection theMateriaLcollection = new materialCollection();
	
	public ProjectRequest(String title, String story, String deadline, String dateposted, double goal, double grade, String cat, Teacher t) {
		this.title=title;
		this.story=story;
		this.goal=goal;
		this.grade=grade;
		setCategory(cat);
		this.t=t;
		this.stat=project_status.IN_PROGRESS;
		setdateposted(dateposted);
		setdeadline(deadline);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public double getGoal() {
		return goal;
	}
	public void setGoal(double goal) {
		this.goal = goal;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public Date getTime() {
		return deadline;
	}
	
	public Date getdateposted() {
		return dateposted;
	}
	
	public void setdeadline(String deadline) {
		Date date = null;
		
		try {
		date = new SimpleDateFormat("dd/MM/yyyy").parse(deadline); // translate the String to Date format
		
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		this.deadline=date;
	}
	
	public void setdateposted(String dateposted) {
		Date date = null;
		
		try {
		date = new SimpleDateFormat("dd/MM/yyyy").parse(dateposted); // translate the String to Date format
		
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		this.dateposted=date;
	}
	
	public Category getcat(){
		return cat;
	}
	
	public Teacher getTeacher() {
		return t;
	}
	
	public void setCategory(String cat) { //Compare if String cat exists in Categories then the value of the String is assigned
		if(cat.equalsIgnoreCase(Category.SCIENCE.name()) || cat.equalsIgnoreCase(Category.ART.name())||cat.equalsIgnoreCase(Category.HEALTH.name()) || cat.equalsIgnoreCase(Category.SPECIAL_NEED.name())) {
			cat=cat.toUpperCase();
			this.cat=Category.valueOf(cat);
		}
	}
	
	public project_status getStat() {
		return stat;
	}

	public void setStat(project_status stat) {
		this.stat = stat;
	}
	
	public thank_you_Package getThanks() {
		return thanks;
	}

	public void setThanks(thank_you_Package thanks) {
		this.thanks = thanks;
	}
	
	public double estimateTotal() {
		return theDcollection.calculateTotal();
	}
	
	public double Left_to_go() {
		return this.goal-estimateTotal();
	}
	
	public void post_Message(String message, String date, Account a) {
		Message m = new Message(message,date,a);
		theMcollection.addMessage(m);
	}
	
	public void display_Messages() {
		theMcollection.toString();
	}
	
	public void display_Collections() {
		theDcollection.toString();
	}
	
	public void Donate(String d, double amountt) {
		Donation don = new Donation(amountt,d);
		theDcollection.addDonation(don);
	}
	
	@Override
	public String toString() {
		return "title " + title + " story " + story + " goal " + goal + " grade " + grade + " deadline of "+ deadline + " date posted on "+ dateposted + "\n amount left to cover"+ Left_to_go();
	}
}
