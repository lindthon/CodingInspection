package labcodeinspection;

import java.util.Locale;

public class Email {

	private transient final String m_firstName;
	private transient final String m_lastName;
	private transient String password = "";
	private transient String department = "";
	private transient final int defaultpasswordLength = 8;
	private transient String email;

	/**
	    * Email Constructor
	    *
	    * @param  firstName   User's first name
	    * @param  lastName   User's last name
	    * 
	    */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}

	/**
	    * Show the info of the Email
	    *
	    * 
	    * Print the Email information:
	    * - First Name
	    * - Last Name
	    * - Department
	    * - Email
	    * -Password
	    */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	    * Set the value of the department to sales, dev or acct
	    *
	    * @param  depChoice   Department value to set:
	    * depChoice = 1: sales
	    * depChoice = 2: dev
	    * depChoice = 3: acct
	    *  
	    * 
	    */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}

	private String randomPassword(int length) {		
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	    * Generate Email using the first name, last name, department ending with @espol.edu.ec
	    * 
	    */
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		this.email = this.m_firstName.toLowerCase(Locale.US) + this.m_lastName.toLowerCase(Locale.US) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
