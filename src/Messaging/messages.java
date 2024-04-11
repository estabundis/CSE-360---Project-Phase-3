
package Messaging;

import java.util.ArrayList;
import java.util.List;


public class messages {
    // ArrayList to store messages in the thread
    private ArrayList<ArrayList<String>> messageThread;
    // List to store people involved in the conversation
    private List<String> people;

    // Constructor
    public messages(String personA) {
        messageThread = new ArrayList<ArrayList<String>>();
        people = new ArrayList<String>();
        people.add(personA);
    }

    public void sendMessage(String person, String Content) {
    	if(person != checkPer(person)) {
    		System.out.println("Person does not exist in this thread");
    		return;
    	} else if (person == getintiP()) {
        System.out.println("Can't Send Message to Yourself");
        return; 
        }

    	ArrayList<String> dict = new ArrayList<String>();
    	dict.add(getintiP());
    	dict.add(Content);
        messageThread.add(dict);

        System.out.println("Message Sent Successfully!\n");
    }

    public void addPerson(String person) {
        
        if (people.contains(person)) 
        System.out.println("Person already added to Portal");
        else {
            people.add(person);
        }

    }

    // Getters and setters for people
    public List<String> getPeople() {
        return people;
    }

 // Getters and setters for people
    public String getintiP() {
        return people.get(0);
    }
 // Getters and setters for people
    public String checkPer(String person) {

        if (people.contains(person))
        return person;
        
        return null;

    }
    
    public String toString() {
    	String value = "";
    	for(int i =0; i<messageThread.size(); i++) {
    		ArrayList<String> dict = messageThread.get(i);
    		value += dict.get(0)+": "+ dict.get(1);
    		value += "\n";
    	}
		return value;
    }
}