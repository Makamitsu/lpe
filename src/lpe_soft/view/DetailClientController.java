/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lpe_soft.model.DataClient;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class DetailClientController implements Initializable {

    @FXML private Label Code; 
    @FXML private Label Nom;
    @FXML private Label AdrFacture;
    @FXML private Label AdrLivraison;
    @FXML private Label Telephone;
    @FXML private Label Fax;
    @FXML private Label Email;
    @FXML private Label Correspondant;
    @FXML private Label Incoterm;
    @FXML private Label EORI;
    @FXML private Label Reglement;
    @FXML private Label transport;
    @FXML private Label PP;
    @FXML private Button btnEdit;
    @FXML private Button btnDelete;
    @FXML private Button btnBack;
    
    private DataClient client;
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditClient.fxml"));
        loader.load();
        EditClientController controller = loader.getController();
        controller.setClient(client);
        Parent root = loader.getRoot();
        Scene scene = Code.getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleDelete(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Vous êtes sur le point de supprimer un client");
        alert.setContentText("Êtes-vous sûr ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
             // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setClient(DataClient client) {
        this.client = client;
        
        this.Code.setText(client.getCodeClient());
        this.Nom.setText(client.getNom());
        this.Correspondant.setText(client.getCorrespondant());
        this.Email.setText(client.getEmail());
        this.Telephone.setText(client.getTelephone());
        this.Fax.setText(client.getFax());
        this.Incoterm.setText(client.getIncoterm());
        this.EORI.setText(client.getEori());
        this.Reglement.setText(client.getReglement());
        this.transport.setText(client.getTransport());
        this.PP.setText(client.getAutorisationPP());
        this.AdrFacture.setText(client.getAdresseFacturation());
        this.AdrLivraison.setText(client.getAdresseLivraison());
    }

    public DataClient getClient() {
        return client;
    }
}
