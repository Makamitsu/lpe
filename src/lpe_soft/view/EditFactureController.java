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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditFactureController implements Initializable {
    
    @FXML private Button btnBack;
    @FXML private Button btnEnregistrer;
    @FXML private Label Nom;
    @FXML private TextArea AdrFacturation;
    @FXML private TextArea AdrLivraison;
    @FXML private Label NCommande;
    @FXML private RadioButton rbtnPalette;        
    @FXML private RadioButton rbtnCarton;
    @FXML private TextField Tdj;
    @FXML private TextField Reglement;
    @FXML private TextField TransportNom;
    @FXML private TextField TransportMode;
    @FXML private TextField NbrColis;
    @FXML private TextField Volume;
    @FXML private DatePicker DateEd;
    
    @FXML
    private void handleBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DetailFacture.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
