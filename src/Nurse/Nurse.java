package Nurse;

import java.util.*;
import Messaging.messages;

public class Nurse 
{

	private String firstName;
	private String lastName;
	private int nurseID;
	private messages messageThread;
	private List<String> healthHistory;
	
	
	public Nurse(String firstName, String lastName, int nurseID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nurseID = nurseID;
    }
	
	// I NEED THE VITALS FORM FOR THE NURSE
	public void enterReportSummary() {
		//this will go to the vitals form when someone makes it, commented out for now
        
		//Vitals.displayHealthForm(this);
    }
	
	// Method to log in 
	public void respondReceiveMessages() {
        // Check if there are any messages for this nurse
        if (messageThread != null) {
            // Retrieve and display messages for this nurse
            System.out.println("Messages for Nurse " + firstName + " " + lastName + ":");
            System.out.println(messageThread.toString()); // Assuming toString() provides a formatted message
        } else {
            System.out.println("No messages for Nurse " + firstName + " " + lastName);
        }
    }
	
	public void accessPatientReport(int patientID) {
        String patientHistory = findPatientHistory(patientID);
        if (patientHistory != null) {
            System.out.println("Patient Health History for ID " + patientID + ":");
            System.out.println(patientHistory);
        } else {
            System.out.println("No health history found for patient ID " + patientID);
        }
    }
	
	private String findPatientHistory(int patientID) {
        for (String history : healthHistory) {
            // Assuming each entry in healthHistory is formatted as "patientID: healthHistory"
            String[] parts = history.split(":");
            if (parts.length == 2 && parts[0].equals(String.valueOf(patientID))) {
                return parts[1]; // Return health history if patient ID matches
            }
        }
        return null; // Return null if no matching health history found
    }
	
	public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }
	
}


