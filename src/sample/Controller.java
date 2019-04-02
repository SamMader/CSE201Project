package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
	ourApplication a;
	@FXML Text title;
	@FXML Text description;
	@FXML Text rating;
	public void update() {
		a = new ourApplication("Test", "This is a test.", 5, 0, 69, 0, null, null);
		title = new Text();
		title.setText(a.name);
		description = new Text();
		description.setText(a.description);
		rating = new Text();
		rating.setText(Double.toString(a.rating));
	}
}
