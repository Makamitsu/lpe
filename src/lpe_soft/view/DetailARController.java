package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class DetailARController implements Initializable {

    @FXML private Button btnDelete;
    @FXML private Button btnBack;
    @FXML private MenuItem btnExporterPDF;
    @FXML private MenuItem btnExporterExcel;
    @FXML private MenuButton btnExporter;
    @FXML private Label Nom;
    @FXML private Label AdrFacturation;
    @FXML private Label AdrLivraison;
    @FXML private Label NCommande;
    @FXML private Label Incoterm;        
    @FXML private Label Suivi;
    @FXML private Label Reglement;
    @FXML private Label RefCommande;
    @FXML private Label DateCommande;
    @FXML private Label Montant;
    
    @FXML
    private void handleBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleExporter(ActionEvent event) throws IOException {
        
    }
    @FXML
    private void handleDelete(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Vous êtes sur le point de supprimer un produit");
        alert.setContentText("Êtes-vous sûr ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
             // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
