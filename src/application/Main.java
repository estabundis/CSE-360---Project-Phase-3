package application;

import Messaging.messages;
import Patient.Patient;
import create_login.doctor;

import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
    	primaryStage.setTitle("Welcome to Koala Clinic");
        
        
        Rectangle topBar = new Rectangle(1000, 60); // Adjust width as needed
        topBar.setFill(Color.BLUE);

        Rectangle sideBarBackRectangle = new Rectangle(300, 600); // Adjust width as needed
        sideBarBackRectangle.setFill(Color.WHITE);
        sideBarBackRectangle.toBack();
        
        BorderPane topPane = new BorderPane();
        topPane.setTop(topBar); // Setting the top bar

        VBox sidebar = new VBox(60);
        Button home_Button = new Button();
        Button profile_Button = new Button(); 
        Button messaging = new Button();
        Button other2_Button = new Button();

        home_Button.setText("HOME");
        profile_Button.setText("PROFILE");
        messaging.setText("MESSAGE");
        other2_Button.setText("OTHER2");

        home_Button.setPrefSize(250, 40);
        profile_Button.setPrefSize(250, 40);
        messaging.setPrefSize(250, 40);
        other2_Button.setPrefSize(250, 40);

        home_Button.toFront();

        home_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        profile_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        messaging.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        other2_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        home_Button.setOnMouseEntered(event -> {
            // Change color when mouse enters
            System.out.println("help me");
        });

        home_Button.setOnMouseExited(event -> {
            // Change color back when mouse exits
            home_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
            "-fx-border-color: #000000; " +
            "-fx-border-width: 2px; " +
            "-fx-text-fill: #ffffff;");
        });

        sidebar.getChildren().addAll(home_Button, profile_Button, messaging, other2_Button); 



        AnchorPane sidebarPane = new AnchorPane();
        AnchorPane.setLeftAnchor(sidebar, 20.0);
        AnchorPane.setTopAnchor(sidebar, 200.0);
        AnchorPane.setLeftAnchor(sideBarBackRectangle, 0.0);
        AnchorPane.setTopAnchor(sideBarBackRectangle, 70.0);
        sidebarPane.getChildren().addAll(sidebar, sideBarBackRectangle);
        sideBarBackRectangle.toBack();
        

        StackPane shareable = new StackPane();
        shareable.setMaxHeight(540);
        shareable.setMaxWidth(700);
        StackPane.setAlignment(shareable, Pos.BOTTOM_RIGHT);
        
        Label WelcomeTitle = new Label("Hello <name> welcome to your screen");
        WelcomeTitle.setFont(Font.font(30));
        shareable.getChildren().add(WelcomeTitle);
        

        StackPane root = new StackPane();  
        root.getChildren().addAll(sidebarPane, topPane, shareable);
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }
    
    public static void PatientDash(Stage primaryStage, Patient patient) {
    	primaryStage.setTitle("Welcome to Koala Clinic mr. patient");
        
        
        Rectangle topBar = new Rectangle(1000, 60); // Adjust width as needed
        topBar.setFill(Color.BLUE);

        Rectangle sideBarBackRectangle = new Rectangle(300, 600); // Adjust width as needed
        sideBarBackRectangle.setFill(Color.WHITE);
        sideBarBackRectangle.toBack();
        
        BorderPane topPane = new BorderPane();
        topPane.setTop(topBar); // Setting the top bar

        VBox sidebar = new VBox(60);
        Button home_Button = new Button();
        Button profile_Button = new Button(); 
        Button messaging = new Button();
        Button other2_Button = new Button();

        home_Button.setText("HOME");
        profile_Button.setText("PROFILE");
        messaging.setText("MESSAGE");
        other2_Button.setText("OTHER2");

        home_Button.setPrefSize(250, 40);
        profile_Button.setPrefSize(250, 40);
        messaging.setPrefSize(250, 40);
        other2_Button.setPrefSize(250, 40);

        home_Button.toFront();

        home_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        profile_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        messaging.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        other2_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
        "-fx-border-color: #000000; " +
        "-fx-border-width: 2px; " +
        "-fx-text-fill: #ffffff;");

        home_Button.setOnMouseEntered(event -> {
            // Change color when mouse enters
            System.out.println("help me");
        });

        home_Button.setOnMouseExited(event -> {
            // Change color back when mouse exits
            home_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
            "-fx-border-color: #000000; " +
            "-fx-border-width: 2px; " +
            "-fx-text-fill: #ffffff;");
        });

        sidebar.getChildren().addAll(home_Button, profile_Button, messaging, other2_Button); 



        AnchorPane sidebarPane = new AnchorPane();
        AnchorPane.setLeftAnchor(sidebar, 20.0);
        AnchorPane.setTopAnchor(sidebar, 200.0);
        AnchorPane.setLeftAnchor(sideBarBackRectangle, 0.0);
        AnchorPane.setTopAnchor(sideBarBackRectangle, 70.0);
        sidebarPane.getChildren().addAll(sidebar, sideBarBackRectangle);
        sideBarBackRectangle.toBack();
        

        StackPane shareable = new StackPane();
        shareable.setMaxHeight(540);
        shareable.setMaxWidth(700);
        StackPane.setAlignment(shareable, Pos.BOTTOM_RIGHT);
        
        Label WelcomeTitle = new Label("Hello <name> welcome to your screen");
        WelcomeTitle.setFont(Font.font(30));
        shareable.getChildren().add(WelcomeTitle);
        

        StackPane root = new StackPane();  
        root.getChildren().addAll(sidebarPane, topPane, shareable);
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }
}