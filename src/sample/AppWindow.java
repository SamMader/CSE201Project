package cse201;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppWindow extends Application {
	
	ourApplication a;
	@FXML Text title;
	@FXML Text description;
	@FXML Text rating;
	
	public AppWindow(ourApplication x) {
		a = x;
	}
	
	public AppWindow() {
		a = new ourApplication("Test", "This is a test.", 5, 0, 69, 0, null, null);
	}

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(a.name);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
}
