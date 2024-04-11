package Messaging;
import java.util.Scanner;

public class Testmessage {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please Enter your name? (Delete this later):\t");
		String sender = scanner.nextLine();

		messages portal = new messages(sender);
		
		System.out.print("Who are you sending a message to? (This should be clicking a button later):\t");
		String sendTo = scanner.nextLine();
		String name = sendTo;


		portal.addPerson(sendTo);

		int option = 1;

		while (option != 0) {
		
			

			System.out.println("Send Message:\t 1");
			System.out.println("See Messages:\t 2");
			System.out.println("Exit:\t 0");
			// What to change this so you can switch or save or whatever
			
			option = scanner.nextInt();

			switch (option) {
			
				case 1: {
				String text;

				System.out.print("\nSend:\t");
				scanner.nextLine();
				text = scanner.nextLine();

				portal.sendMessage(sendTo, text);

				}
			
				break; 
				case 2: {
				System.out.println("\n==Messages==\n"); 
				System.out.println("\n" + portal); 	
				}
				break;

				default: System.out.println("\n==Please Try Again!==\n");

			}
			
		}


		scanner.close();

	}
	
}
