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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class EditProduitController implements Initializable {

    @FXML private TextField Code; 
    @FXML private ComboBox Famille;
    @FXML private RadioButton rbtnOui;        
    @FXML private RadioButton rbtnNon;
    @FXML private TextField MOE;
    @FXML private TextField Nomenclature;
    @FXML private TextField Poids;
    @FXML private TextField Prix;
    @FXML private TextField PrixMP;
    @FXML private TextField CodeDouanier;
    @FXML private TextField Taxedouanes;
    @FXML private TextField Kit;
    @FXML private TextField Libelle;
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
        Nomenclature.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 1) {
                    Nomenclature.setText(newValue.substring(0, 1));
                }
            }
        });
        CodeDouanier.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    CodeDouanier.setText(newValue.substring(0, 10));
                }
            }
        });
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
                if (!newValue.matches("^\\d+\\,?\\d*$")) {
                    PrixMP.setText(newValue.replaceAll("((?=[\\D])\\w)", ""));
                }
            }
        });
        Prix.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("^\\d+\\,?\\d*$")) {
                    Prix.setText(newValue.replaceAll("((?=[\\D])\\w)", ""));
                }
            }
        });
        Poids.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("^\\d+\\,?\\d*$")) {
                    Poids.setText(newValue.replaceAll("((?=[\\D])\\w)", ""));
                }
            }
        });
    }    
    
}
