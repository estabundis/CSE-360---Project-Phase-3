module CSE360_ph3 {
	requires javafx.controls;
	
	exports create_login;
	opens application to javafx.graphics, javafx.fxml;
}
