package CSE201;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {

    User currentUser = null;

    //Linking FXML to Controller
    @FXML
    TextField username = new TextField();
    @FXML
    PasswordField password = new PasswordField();
    @FXML
    Button loginButton = new Button();

    // User database, temporary until real database set up, also size will change.
    ArrayList<User> userList = new ArrayList<>();

    // On click, check if user exists, if true, return user to main program
    public void login() {
        String user = username.getText();
        String pass = password.getText();
        boolean gotUser = false;
        for (User x: userList) {
            if (x.getUsername().equals(user)) {
                if (x.getPassword().equals(pass)) {
                    currentUser.write(x);
                    gotUser = true;
                }
            }
        }
        if (gotUser) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Login");
            alert.setHeaderText("Incorrect Login");
            alert.setContentText("Incorrect Username or Password, please try again.");
            alert.showAndWait();
            username.clear();
            password.clear();
        }
    }

    public void transferUser(User a) {
       currentUser = a;
    }

    public void transferUserDB(ArrayList<User> a) {userList = a;}

}
