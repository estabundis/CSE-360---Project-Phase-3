package Patient;

import java.util.*;
import java.io.Serializable;

public class Patient implements Serializable
{
	// Attributes 
	private String firstName;
	private String lastName;
	private int birthday;
	private String email;
	private String password;
	private String patientID;
	private List<String> healthHistory;
	
	
	// Methods 
	
	// Provide personal information 
	// This will be use when the patients enter their input 
	public Patient()
	{
		this.healthHistory = new ArrayList<>();
	}
	
	// Method to create an account 
	public void createAccount(String firstName, String lastName, int birthday, String email, String password)
	{
		// Generate patient ID after patient click on create account button 
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.patientID = generatePatientID();
		
		System.out.println("Sign up successful. Welcome, " + firstName + " " + lastName + "!");
        // Display options available to the user
        displayUserOptions();
		
	}
	
	// Method to log in 
	public void logIn(String userEmail, String userPassword)
	{
		// Provide email and password to log into the system 
		if(userEmail.equals(email) && userPassword.equals(password))
		{
			// Proceed to the main UI page
			
			System.out.println("Login successful. Welcome, " + firstName + " " + lastName + "!");
	        // Display options available to the user
	        displayUserOptions();
		}
		else
		{
			System.out.print("Your email or password is incorrect. Please try again!");
		}
	}
	
	// Method 
	public void updateContactInfo(String firstName, String lastName, int birthday, String email, String password)
	{
		// Update patient's personal information
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
	}
	
	public void requestHealthHistory()
	{
        if (healthHistory.isEmpty()) {
            System.out.println("No health history available.");
        } else {
            System.out.println("Health History:");
            for (String record : healthHistory) {
                System.out.println(record);
            }
        }
	}
	
	public String generatePatientID()
	{
		int uniqueNum;
    	Random random = new Random();
    	uniqueNum = random.nextInt(90000) + 10000;
    	return Integer.toString(uniqueNum);
	}
	
	private void displayUserOptions() {
	    System.out.println("Options:");
	    System.out.println("1. Update contact information");
	    System.out.println("2. Request health history");
	    System.out.println("3. Message with doctor/nurse/staff");
	    System.out.println("4. View appointments");

	}
}

