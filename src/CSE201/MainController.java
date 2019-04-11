package CSE201;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    User currentUser = new User("", "", "");
    ArrayList<User> userArrayList = new ArrayList<>();

    @FXML
    Button loginButton;
    @FXML
    Button logoutButton;
    @FXML
    Text category = new Text();
    @FXML
    Text userName = new Text();
    @FXML
    TextField searchBar = new TextField();
    @FXML
    VBox appsBox = new VBox();

    public void loginButtonAction() {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            LoginController scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferUser(currentUser);
            scene2Controller.transferUserDB(userArrayList);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.showAndWait();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        if (currentUser != null) {
            userName.setText(currentUser.getRealName());
            loginButton.setVisible(false);
            logoutButton.setVisible(true);
        }
    }

    public void logoutAction() {
        currentUser.write(new User("", "", ""));
        userName.setText("N/A");
        logoutButton.setVisible(false);
        loginButton.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userArrayList.add(new User("Test 1", "6969", "Sam"));
        logoutButton.setVisible(false);
        category.setText("All Applications");
    }

    public void sort() {

    }
}
