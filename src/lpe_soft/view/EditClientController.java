/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DetailClient.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        System.out.println("save client ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}