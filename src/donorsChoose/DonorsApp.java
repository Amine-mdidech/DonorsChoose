package donorsChoose;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import donorsChoose.Classes.Account;
import donorsChoose.Classes.Donor;
import donorsChoose.Classes.Profile;
import donorsChoose.Classes.ProjectRequest;
import donorsChoose.Classes.Teacher;
import donorsChoose.Classes.User;
import donorsChoose.Exceptions.GenderException;
import donorsChoose.Exceptions.SmallPasswordException;
import donorsChoose.collections.accountCollection;
import donorsChoose.collections.projectCollection;

public class DonorsApp {
	
	public static void main(String[] args){
		
		accountCollection theAcollection=new accountCollection();
		projectCollection thePcollection=new projectCollection();
		try {
			theAcollection.load();
		}
		catch(ClassNotFoundException | IOException cnf) {
			System.out.println(" File not found ");
		}
		
		try {
			thePcollection.load();
		}
		catch(ClassNotFoundException | IOException cnf) {
			System.out.println(" File not found ");
		}
		
		Account theEnteredAccount=null;
		int app = 1; // integer that keeps the app looping
		while(app==1){
			
			System.out.println("\n Welcome to DonorsApp\n\n Menu \n 1-Create an account \n 2-log in  \n 3-Exit ");
			System.out.println("\n Enter number");
			
			Scanner scanner = new Scanner(System.in);
			
			int menu = scanner.nextInt();
			boolean loginstatus = false; // login status that gives access to the second menu
			
			switch(menu) {
			
			case 1 : 
				Account a =createAccount();
				theAcollection.addAccount(a);
				try {
					theAcollection.save();
				}catch(IOException cnf) {
				}
				break;
			case 2 :
				theEnteredAccount=logIn(theAcollection);
				if(theEnteredAccount==null) {
				System.out.println(" Wrong email or password \n Don't have an account ? Create One");
				}
				break;
				
			default : // termination of the app loop
				System.out.println(" Bye !  And Thank you For using the DonorApp  ");
				app=0;
			}
			
			while(theEnteredAccount!=null) { // second menu when the user log in
				if(theEnteredAccount.getUser() instanceof Teacher) {
					Teacher u1 = (Teacher) theEnteredAccount.getUser();
					System.out.println("Welcome Teacher \n 1-Search Projects 2- Post Project 3- Mark Project as Expired 4-Post Thank you note 5-Update Profile"
							+ " 6-exit");
					int menu2 = scanner.nextInt();
					switch(menu2) {
					case 1 :
						//SearchAccount(theAcollection);
						break;
					case 2 : //testing the project request creation and adding to collection + saving
						String title="kid project";String story="I love kids";String dateposted="05/07/2020";String deadline="20/05/2021";
						double goal = 50000; double grade=3.75;
						String cat="ART";
						u1.Post_Project(title, story, deadline, dateposted, goal, grade, cat, u1,thePcollection);
						try {
							thePcollection.save();
						}catch(IOException cnf) {
						}
						break;
					default: // termination of second loop
					
					theEnteredAccount=null;
					}
				}
				else if(theEnteredAccount.getUser() instanceof Donor) {
					Donor d1 = (Donor) theEnteredAccount.getUser();
					System.out.println("1-Search Projects 2- Donate 3-Add project to wishlist 4-remove project to wishlist 5-Update Profile 6-exit");
					int menu2 = scanner.nextInt();
					switch(menu2) {
					case 1 :
						SearchAccount(theAcollection);
						break;
					case 2 : 
						String title="kid project";String dateposted="05/07/2020"; String d="05/08/2020"; double amountt=10000;
						ProjectRequest r=thePcollection.findProject(title, dateposted);
						d1.donor_donate(r,d,amountt);
						System.out.println(r.toString());
						try {
							thePcollection.save();
						}catch(IOException cnf) {
						}
						break;
					default: // termination of second loop 
						theEnteredAccount=null;
					}
				}
			}
	}
}
	
	public static Account createAccount() { // function that creates the account and add it to the list
		Scanner scanner = new Scanner(System.in);
		System.out.println(" \n Creating your Account\n Enter your email : ");
		String email = scanner.nextLine();
		System.out.println(" Enter Password : ");
		String password = scanner.nextLine();
		
		System.out.println(" Now enter your Profile Information \n");
		System.out.println(" Enter your First name : ");
		String F_name = scanner.nextLine();
		System.out.println(" Enter your Last name : ");
		String L_name = scanner.nextLine();
		System.out.println(" Enter Birthdate dd/mm/yyyy : ");
		String birthdate= scanner.nextLine();
		System.out.println(" Enter your Gender : ");
		String gender= scanner.nextLine();
		System.out.println(" Enter your Address : ");
		String address = scanner.nextLine();
		Profile p1 = null;
		while(true) {
			try {
				p1 = new Profile(F_name,L_name,birthdate,gender,address);
				break;
			}catch (GenderException pp) {
				System.out.println(pp.getMessage());
				System.out.println(" Available genders :");
				String[] avgenders= pp.getAvailableGenders();
				System.out.println(" Try again :");
				gender = scanner.nextLine();
			}
		}
		System.out.println(" Are you a Teacher ? ");
		String answer = scanner.nextLine();
		User u1;
		if(answer.toUpperCase().equals("YES")) {
			u1 = new Teacher(p1); //Polymorphic Call to teacher
		}
		else {
			u1 = new Donor(p1);//Polymorphic Call to donor
		}
		Account a1 = null;
		while(true) {
			try {
				a1 = new Account(email,password,u1);
				break;
			}catch ( SmallPasswordException spp) {
				System.out.println(spp.getMessage());
				System.out.println(" Enter Password again : ");
				password = scanner.nextLine();
			}
		}
		
		return a1;
	}
	
	public static Account logIn(accountCollection thecollection) { // log in function that check if the email and password both exists
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(" Enter email ");
		String e_mail = scanner.nextLine();
		System.out.println(" Enter password ");
		String password = scanner.nextLine();
		
		Account u= thecollection.searchAccountemailpassword(e_mail,password);
		if(u!=null) {
			return u;
		}else {
			return null;
		}
		
	}
	
	public static void SearchAccount(accountCollection thecollection){ // function that searches and account by prompting for the last name
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Enter Last name : \n");
		String thename = scanner.nextLine();
		ArrayList<Account> us = thecollection.searchAccount(thename);
		for(Account s : us) {
			System.out.println(s.toString());
		}
		
	}
	
}
