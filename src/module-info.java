module CSE360_ph3 {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	exports Profile;
	exports create_login;
	exports Patient;
}
