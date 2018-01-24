/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class EditProduitController implements Initializable {

    @FXML private TextField Code; 
    @FXML private ComboBox Famille;
    @FXML private TextField RoHS;
    @FXML private TextField MOE;
    @FXML private TextField Nomenclature;
    @FXML private TextField Poids;
    @FXML private TextField Prix;
    @FXML private TextField PrixMP;
    @FXML private TextField CodeDouanier;
    @FXML private TextField Taxedouanes;
    @FXML private TextField Kit;
    @FXML private Button btnSave;
    @FXML private Button btnBack;
    
    @FXML
    private void handleBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DetailProduit.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        System.out.println("save produit ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Taxedouanes.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("^\\d+\\,?\\d*$")) {
                    Taxedouanes.setText(newValue.replaceAll("((?=[\\D])\\w)", ""));
                }
            }
        });
        PrixMP.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    PrixMP.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Prix.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Prix.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Poids.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Poids.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }    
    
}
