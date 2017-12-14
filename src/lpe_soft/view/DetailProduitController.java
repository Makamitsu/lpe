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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lpe_soft.model.DataProduit;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class DetailProduitController implements Initializable {

    @FXML private Label Code; 
    @FXML private Label Famille;
    @FXML private Label RoHS;
    @FXML private Label MOE;
    @FXML private Label Nomenclature;
    @FXML private Label Poids;
    @FXML private Label Prix;
    @FXML private Label PrixMP;
    @FXML private Label CodeDouanier;
    @FXML private Label Taxedouanes;
    @FXML private Label Kit;
    @FXML private Button btnEdit;
    @FXML private Button btnDelete;
    @FXML private Button btnBack;
    private DataProduit produit;
    
    @FXML
    private void handleBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Produit.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleEdit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditProduit.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setProduit(DataProduit row) {
        this.produit = row;

        Code.setText(produit.getCode());
        Famille.setText(produit.getType());
        Prix.setText(Float.toString(produit.getPrix()));
    }
}
