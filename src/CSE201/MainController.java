package CSE201;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    User currentUser = new User();

    @FXML
    Button loginButton;
    @FXML
    Text userName = new Text();

    public void loginButtonAction() {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            LoginController scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferUser(currentUser);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        if (currentUser.getUsername() != null) {
            userName.setText(currentUser.getUsername());
        }
    }

}
