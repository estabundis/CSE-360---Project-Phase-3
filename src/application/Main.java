package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Messaging.messages;
import Patient.*;
import create_login.doctor;
import Profile.Profile;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
 
public class Main {
    public static void main(String[] args) {
//    	Patient myPatient = new Patient();
//    	Stage primaryStage = new Stage();
//    	myPatient.createAccount("Pratyusha", "Kumar", "12/3/2004", "pk@gmail.com", "hello");
//        Dashboard(primaryStage, myPatient);
    }
    
    public static void Dashboard(Stage primaryStage, Object currentUser) {
    	if(currentUser instanceof Patient) {
    		Patient myPatient = (Patient) currentUser;
    		PatientDash(primaryStage, myPatient);
    	}
    	else if(currentUser instanceof doctor){
    		doctor mydoctor = (doctor) currentUser;
    		DoctorDash(primaryStage, mydoctor);
    	}
        
    }
    
    public static void DoctorDash(Stage primaryStage, doctor Doctor) {
    	BorderPane root = new BorderPane();
        
        // Create a VBox on the left side
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(250);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setStyle("-fx-background-color: white;");
        leftBox.setSpacing(10);
        
        // Create buttons
        Button homeButton = new Button("HOME");
        homeButton.setPrefSize(150, 55);
        homeButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        
        Button healthFormButton = new Button("HEALTH FORM");
        healthFormButton.setPrefSize(150, 55);
        healthFormButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        healthFormButton.setOnAction(e -> {
        	Healthform a = new Healthform();
        	a.healthform(primaryStage, Doctor);
//        	System.out.println("hell");
        });
        
        Button view = new Button("VIEW REPORTS");
        view.setPrefSize(150, 55);
        view.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        view.setOnAction(e -> {
        	Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Patient Information");

            Label patientIdLabel = new Label("Patient ID:");
            TextField patientIdTextField = new TextField();
            
            
            VBox rot = new VBox(20);
            rot.getChildren().addAll(patientIdLabel,patientIdTextField );
            HBox coot = new HBox();
            Button viewButton = new Button("View");
            viewButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 16px; -fx-pref-width: 150px;");
            viewButton.setOnAction(x -> {
            	String filename = patientIdTextField.getText()+"_patient.bin";
        		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
                    Patient obj = (Patient) objectInputStream.readObject();
                    // Process the object as needed
                    
                    viewReports(primaryStage, obj);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            });
            coot.getChildren().addAll(rot, viewButton);
            StackPane sss = new StackPane();
            sss.getChildren().addAll(coot);
            Scene scene = new Scene(sss, 1000, 600);
            popupStage.setScene(scene);
            popupStage.show();
        });
        
        Button messageButton = new Button("MESSAGE");
        messageButton.setPrefSize(150, 55);
        messageButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        Button otherButton = new Button("PATIENT REPORT");
        otherButton.setPrefSize(150, 55);
        otherButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        otherButton.setOnAction(e -> DoctorReport(primaryStage, Doctor));
        
        HBox blue = new HBox();
        blue.setStyle("-fx-background-color: blue;");
        blue.setMinHeight(60);
        blue.setMinWidth(1000);
        // Add buttons to VBox
        leftBox.getChildren().addAll(homeButton, healthFormButton, messageButton,otherButton ,view);
        
        // Set VBox on the left side of the BorderPane
        root.setLeft(leftBox);
        root.setTop(blue);
        
        
        
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private static void viewReports(Stage primaryStage, Patient obj) {
		TextArea Reports = new TextArea();
		String value = "";
		int kk = 1;
		for(String item: obj.getReports()) {
			value += "Report " + kk + ":\n" + item + "\n";
			kk++;
		}
		
	}

	private static void DoctorReport(Stage primaryStage, doctor mdoctor) {
    	// Create labels
        Label patientIdLabel = new Label("Patient ID:");
        Label reportLabel = new Label("Report:");

        // Create text fields
        TextField patientIdTextField = new TextField();

        // Create text area
        TextArea reportTextArea = new TextArea();

        // Create buttons
        Button saveButton = new Button("Save");
        Button backButton = new Button("Back");

        // Styling buttons
        saveButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 16px; -fx-pref-width: 150px;");
        backButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 16px; -fx-pref-width: 150px;");

        backButton.setOnAction(e ->{Main.Dashboard(primaryStage, mdoctor);});
        saveButton.setOnAction(e -> {
        	if(patientIdTextField.getText().isBlank() || reportTextArea.getText().isBlank()) {
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Fill all the fields");
        	} 
        	else {
        		String file = patientIdTextField.getText() + "_patient.bin";
        		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                    Patient obj = (Patient) objectInputStream.readObject();
                    // Process the object as needed
                    obj.addRopert(reportTextArea.getText());
                    System.out.println("Object read from file: " + obj.getFirstName());
                    Main.Dashboard(primaryStage, mdoctor);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
        	}
        });	
        
        
        // Create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add components to the grid pane
        gridPane.add(patientIdLabel, 0, 0);
        gridPane.add(patientIdTextField, 1, 0);
        gridPane.add(reportLabel, 0, 1);
        gridPane.add(reportTextArea, 0, 2, 2, 1);
        gridPane.add(saveButton, 0, 3);
        gridPane.add(backButton, 1, 3);

        // Create a scene
        Scene scene = new Scene(gridPane, 1000, 600);

        // Set the scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Medical Report");
        primaryStage.show();
		
	}

	public static void PatientDash(Stage primaryStage, Patient patient) {
    	BorderPane root = new BorderPane();
        
        // Create a VBox on the left side
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(250);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setStyle("-fx-background-color: white;");
        leftBox.setSpacing(10);
        
        // Create buttons
        Button homeButton = new Button("HOME");
        homeButton.setPrefSize(150, 55);
        homeButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        
        Button healthFormButton = new Button("PROFILE");
        healthFormButton.setPrefSize(150, 55);
        healthFormButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        healthFormButton.setOnAction(e -> 
        	{Profile p = new Profile();
        	p.profile(primaryStage, patient);
        	
        	});
        
        Button messageButton = new Button("MESSAGE");
        messageButton.setPrefSize(150, 55);
        messageButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        Button otherButton = new Button("Report");
        otherButton.setPrefSize(150, 55);
        otherButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        otherButton.setOnAction(e -> {
        	viewReports(primaryStage, patient);
        });
        HBox blue = new HBox();
        blue.setStyle("-fx-background-color: blue;");
        blue.setMinHeight(60);
        blue.setMinWidth(1000);
        // Add buttons to VBox
        leftBox.getChildren().addAll(homeButton, healthFormButton, messageButton, otherButton);
        
        // Set VBox on the left side of the BorderPane
        root.setLeft(leftBox);
        root.setTop(blue);
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}