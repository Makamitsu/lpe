/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
import lpe_soft.model.DataClient;
import lpe_soft.model.UserBean;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class EditClientController implements Initializable {

    @FXML private TextField Code; 
    @FXML private TextField Nom;
    @FXML private TextField AdrFacture;
    @FXML private TextField AdrLivraison;
    @FXML private TextField Telephone;
    @FXML private TextField Fax;
    @FXML private TextField Email;
    @FXML private TextField Correspondant;
    @FXML private TextField Incoterm;
    @FXML private TextField EORI;
    @FXML private TextField Reglement;
    @FXML private TextField transport;
    @FXML private TextField PP;
    @FXML private Button btnSave;
    @FXML private Button btnBack;
    
    private DataClient client;
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DetailClient.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        UserBean ub = new UserBean();
        System.out.println(client);
        getNewValue();
        System.out.println(client);
        ub.updateClient(client);

        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setClient(DataClient client){
        this.client = client;
        
        this.Code.setText(client.getCodeClient());
        this.Nom.setText(client.getNom());
        this.AdrFacture.setText(client.getAdresseFacturation());
        this.AdrLivraison.setText(client.getAdresseLivraison());
        this.Telephone.setText(client.getTelephone());
        this.Fax.setText(client.getFax());
        this.Email.setText(client.getEmail());
        this.Correspondant.setText(client.getCorrespondant());
        this.Incoterm.setText(client.getIncoterm());
        this.EORI.setText(client.getEori());
        this.Reglement.setText(client.getReglement());
        this.transport.setText(client.getTransport());
        this.PP.setText(client.getAutorisationPP());
    }

    private void getNewValue() {
        this.client = new DataClient(
                this.client.getID(),
                this.Code.getText(),
                this.Nom.getText(),
                this.Telephone.getText(),
                this.Fax.getText(),
                this.Email.getText(),
                this.Correspondant.getText(),
                this.Incoterm.getText(),
                this.EORI.getText(),
                this.Reglement.getText(),
                this.transport.getText(),
                this.PP.getText(),
                "", //Valeur du numero d'OF client
                this.AdrFacture.getText(),
                this.AdrLivraison.getText());
    }
    
}