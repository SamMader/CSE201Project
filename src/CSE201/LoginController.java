package CSE201;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

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
    public User login() {
        String user = username.getText();
        String pass = password.getText();
        for (int x = 0; x < database.length; x++) {
            User y = database[x];
            if (y.login(user, pass)) {
                return y;
            }
        }
        return null;
    }

}
