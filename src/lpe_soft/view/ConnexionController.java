package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lpe_soft.model.UserBean;

public class ConnexionController implements Initializable {

    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Label invalid_label;
    @FXML private TextField username_box;
    @FXML private PasswordField password_box;

    private String login;
    private String password;

    @FXML
    private void handleButtonConnexion(ActionEvent event) throws IOException, SQLException {    
        if (event.getSource() == btn1) {
            login = username_box.getText();
            password = password_box.getText();
            UserBean ubean = new UserBean();
            if (ubean.Connexion(login, password)) {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();
            } else {
                username_box.clear();
                password_box.clear();
                invalid_label.setText("Identification invalide");
            }
        } else {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Password.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
