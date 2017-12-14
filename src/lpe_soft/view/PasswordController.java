package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class PasswordController implements Initializable {
    
    @FXML private Button btnBack;
    @FXML private Button btnOk;
    @FXML private Label envoie;
    @FXML private TextField email;
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void handleEnvoie(ActionEvent event) throws IOException {
        if ((email.getText().isEmpty())) {
            envoie.setText("Email vide");
        } else if(true){ //verification BDD
            envoie.setText("Email envoyer");
        }
        else {
            envoie.setText("Email incorrecte");
        }
        email.clear();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
