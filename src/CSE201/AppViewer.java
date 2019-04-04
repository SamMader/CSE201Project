package CSE201;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppViewer extends Application {

    ApplicationEntry app;

    public AppViewer(ApplicationEntry a) {
        app = a;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("appview.fxml"));
        primaryStage.setTitle(app.name);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

}
