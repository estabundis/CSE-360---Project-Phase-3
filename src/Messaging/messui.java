package Messaging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Patient.Patient;
import application.Main;
import create_login.doctor;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class messui {
	public void messui(Stage primaryStage, doctor dd , Patient pp, Boolean patient) throws ClassNotFoundException, IOException{
		
		String fileName = pp.getID()+ "msg.bin";

        try {
            // Check if the file exists
            File file = new File(fileName);

            if (!file.exists()) {
                // If the file does not exist, create it
                file.createNewFile();
                System.out.println("File created: " + file.getName());
             // Create ObjectOutputStream to write objects to the file
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                // Writing data to the file
                messages m = new messages("Dr. "+dd.getFirstName(), pp.getFirstName());
                objectOutputStream.writeObject(m);
             // Close the ObjectOutputStream
                objectOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        FileInputStream fileOutputStream = new FileInputStream(fileName);
        ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
        messages m = (messages) objectOutputStream.readObject();
        objectOutputStream.close();
	// Create TextArea for messages
    TextArea textArea = new TextArea();
    textArea.setEditable(false);
    textArea.setText(m.toString());
    
    // Create HBox for input field and send button
    TextField textField = new TextField();
    Button sendButton = new Button("Send");
    sendButton.setOnAction(e ->{
    	if(textField.getText().isBlank()) {
    		return;
    	}
    	if(patient) {
    		m.sendMessage(pp.getFirstName(), textField.getText());
    	}
    	else {
    		m.sendMessage("Dr. "+dd.getFirstName(), textField.getText());
    	}
    	
		try {
			FileOutputStream f = new FileOutputStream(pp.getID()+"msg.bin");
	        ObjectOutputStream n= new ObjectOutputStream(f);
	        n.writeObject(m);
	        n.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	textArea.setText(m.toString());
    });
    HBox inputBox = new HBox(10, textField, sendButton);
    inputBox.setPadding(new Insets(10));

    // Set the send button to grow to fill available space
    HBox.setHgrow(textField, Priority.ALWAYS);

    // Create a button for back
    Button backButton = new Button("Back");
    // Event handling for back button can be added here
    backButton.setOnAction(e ->{
    	if(patient) {
    		Main.Dashboard(primaryStage, pp);
    	}
    	else {
    		Main.Dashboard(primaryStage, dd);
    	}
    });
    // Add the components to the root pane
    VBox root = new VBox();
    root.getChildren().addAll(textArea, inputBox);
    BorderPane.setAlignment(backButton, javafx.geometry.Pos.BOTTOM_LEFT);
    BorderPane.setMargin(backButton, new Insets(10));
    BorderPane borderPane = new BorderPane(root, null, null, backButton, null);

    // Create the scene and set it to the stage
    Scene scene = new Scene(borderPane, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Chat Application");
    primaryStage.show();
}}
