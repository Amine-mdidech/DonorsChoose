package donorsChoose;

import java.util.Date;

public class ProjectRequest {
	
	private String title;
	private String story;
	private double goal;
	private double grade;
	private Date deadline;
	private Date dateposted;
	private Category cat;
	
	public ProjectRequest(String title, String story, Date deadline, Date dateposted, double goal, double grade, String cat) {
		this.title=title;
		this.story=story;
		this.goal=goal;
		this.grade=grade;
		setCategory(cat);
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
	
	public void setTime(Date deadline) {
		this.deadline=deadline;
	}
	
	public void setdateposted(Date dateposted) {
		this.dateposted=dateposted;
	}
	
	public Category getcat(){
		return cat;
	}
	
	public void setCategory(String cat) { //Compare if String cat exists in Categories then the value of the String is assigned
		if(cat.equalsIgnoreCase(Category.Category1.name()) || cat.equalsIgnoreCase(Category.Category2.name())||cat.equalsIgnoreCase(Category.Category3.name()) || cat.equalsIgnoreCase(Category.Category4.name())) {
			cat=cat.toUpperCase();
			this.cat=Category.valueOf(cat);
		}
	}


	@Override
	public String toString() {
		return "title " + title + " story " + story + " goal " + goal + " grade " + grade + " deadline of "+ deadline + "date posted on "+ dateposted;
	}
	
	
}
