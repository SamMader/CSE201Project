package CSE201;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    User[] database = new User[1];

    // On click, check if user exists, if true, return user to main program
    public void login() {
        String user = username.getText();
        String pass = password.getText();
        boolean gotUser = false;
        for (int x = 0; x < database.length; x++) {
            User y = database[x];
            if (y.getUsername().equals(user)) {
                if (y.getPassword().equals(pass)) {
                    currentUser = y;
                    gotUser = true;
                }
            }
        }
        if (gotUser) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }
        else {
            username.clear();
            password.clear();
        }
    }

    public void transferUser(User a) {
       currentUser = a;
    }

}
