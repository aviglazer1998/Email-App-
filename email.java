package emailProject;
import java.util.Scanner;


public class email {
private String firstName;
private String lastName;
private String department;
private String companyEmail; 
private String altEmail;
private int defaultLength;
private String password;
private int mailCap = 500;
private Object [] list = new email [15];
private String company;
Scanner in = new Scanner(System.in);


public email(String firstName , String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	
	System.out.println("Email made for " + this.firstName + " " + this.lastName);
	
	setDepartment();
	
	System.out.println("Set how many chars your password should be");
	defaultLength = in.nextInt();
	
	this.password = passwordGenerator(defaultLength);
	System.out.println("Your password is " + this.password);
	
	System.out.println("Enter your company in one word");
	company  = in.next();
	
	companyEmail = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + company + ".com";
	
} 

public email nameSearch(String lastName , String firstName) {
	for(int i = 0; i < list.length;i++)
		if((((email) list[i]).getLastName().equalsIgnoreCase(lastName)) && (((email) list[i]).getFirstName().equalsIgnoreCase(firstName))) {
			System.out.println(list[i]);
			return (email) list[i];
		}
	
	System.out.print("Student not found");
	return null;	
}
	public void showInfo() {
		System.out.println(firstName + " " + lastName + " " + department+ " "  +  companyEmail+ " " );
	}

public String getFirstName() {return firstName;}
public void setFirstName(String firstName) {this.firstName = firstName;}
public String getLastName() {return lastName;}
public void setLastName(String lastName) {this.lastName = lastName;}
public String getDepartment() {return department;}
public void setDepartment(String department) {this.department = department;}
public String getCompanyEmail() {return companyEmail;}
public void setCompanyEmail(String companyEmail) {this.companyEmail = companyEmail;}
public String getAltEmail() {return altEmail;}
public void setAltEmail(String altEmail) {this.altEmail = altEmail;}
public int getDefaultLength() {return defaultLength;}
public void setDefaultLength(int defaultLength) {this.defaultLength = defaultLength;}
public String getPassword() {return password;}
public void setPassword(String password) {this.password = password;}
public int getMailCap() {return mailCap;}
public void setMailCap(int mailCap) {this.mailCap = mailCap;}
public String getCompany() {return company;}
public void setCompany(String company) {this.company = company;}
public Scanner getIn() {return in;}
public void setIn(Scanner in) {this.in = in;}

private String setDepartment() {
	
	System.out.println("Enter Your Department: Accounting, Sales, Marketing, Development ");
	
	
	switch (in.next().toLowerCase()) {
	case "accounting":
		this.department = "Accounting";
		break;
	case "marketing":
		this.department = "Marketing";
		break;
	case "sales":
		this.department = "Sales";
		break;
	case "development":
		this.department = "Development";
		break;
	default:
		System.out.println("Incorrect department option");
		break;
		}
	
	return department; 
}


// generate random password
private String passwordGenerator(int length) {
	String passwordSet = "qwertyuiopasdfghjklzxcvbnmABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&-_";
	char [] password = new char [length];
	for(int i =0 ; i < length; i++) {
		int rand = (int) (Math.random() * passwordSet.length());
		password[i] = passwordSet.charAt(rand);
	}
	
	return new String(password);
}
}