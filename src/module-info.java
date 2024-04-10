module CSE360_ph3 {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;

	exports create_login;
	opens application to javafx.graphics, javafx.fxml;

	exports Profile;
	exports Patient;
}
