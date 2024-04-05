package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ASU Hello World Spring 2024");
    
        Rectangle topBar = new Rectangle(1000, 60); // Adjust width as needed
        topBar.setFill(Color.BLUE);

        Rectangle sideBarBackRectangle = new Rectangle(300, 700); // Adjust width as needed
        sideBarBackRectangle.setFill(Color.WHITE);
        sideBarBackRectangle.toBack();
        
        BorderPane topPane = new BorderPane();
        topPane.setTop(topBar); // Setting the top bar

        VBox sidebar = new VBox(60);
        Button home_Button = new Button();
        Button profile_Button = new Button(); 
        Button other_Button = new Button();
        Button other2_Button = new Button();

        home_Button.setText("HOME");
        profile_Button.setText("PROFILE");
        other_Button.setText("OTHER");
        other2_Button.setText("OTHER2");

        home_Button.setPrefSize(250, 40);
        profile_Button.setPrefSize(250, 40);
        other_Button.setPrefSize(250, 40);
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

        other_Button.setStyle("-fx-background-color: Blue; " + // Set background color to blue
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

        sidebar.getChildren().addAll(home_Button, profile_Button, other_Button, other2_Button); 



        AnchorPane sidebarPane = new AnchorPane();
        AnchorPane.setLeftAnchor(sidebar, 20.0);
        AnchorPane.setTopAnchor(sidebar, 200.0);
        AnchorPane.setLeftAnchor(sideBarBackRectangle, 0.0);
        AnchorPane.setTopAnchor(sideBarBackRectangle, 70.0);
        sidebarPane.getChildren().addAll(sidebar, sideBarBackRectangle);
        sideBarBackRectangle.toBack();
        



        StackPane root = new StackPane();  
        root.getChildren().addAll(sidebarPane, topPane);
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.show();
    }
}