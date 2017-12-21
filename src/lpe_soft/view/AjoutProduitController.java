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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lpe_soft.model.DataDesignation;
import lpe_soft.model.DataProduit;
import lpe_soft.model.UserBean;

/**
 *
 * @author hugob
 */
public class AjoutProduitController implements Initializable {
    
    @FXML private Button btnBack;
    @FXML private Button btnEnregistrer;
    @FXML RadioButton rbtnOui;        
    @FXML RadioButton rbtnNon;
    @FXML ComboBox comboClient;
    @FXML ComboBox comboDesignation;
    @FXML TextField codeProduitField;
    @FXML TextField moeField;
    @FXML TextField nomenclature;
    @FXML TextField poids;
    @FXML TextField prix;
    @FXML TextField prixMat;
    @FXML TextField codeDouanier;
    @FXML TextField droitDouane;
    @FXML Label infoValid;

    @FXML
    private void buttonAdd(ActionEvent event) throws IOException{
        UserBean ub = new UserBean();
        float f;
        try {
            f = Float.parseFloat(prix.getText());    
            if( !codeProduitField.getText().equals("") && comboDesignation.getValue() != null ) {
                DataProduit newProduit = new DataProduit(
                    codeProduitField.getText(),
                    ((DataDesignation) comboDesignation.getValue()).getValue(),
                    f);
                if (ub.addNewProduct(newProduit)){
                    Parent root = FXMLLoader.load(getClass().getResource("Produit.fxml"));
                    Scene scene = btnBack.getScene();
                    scene.setRoot(root);
                }else{
                    infoValid.setText("Une erreur est survenue.");
                }
            }
        }catch(NumberFormatException e){
            System.err.println(e.getMessage());
        }
    }
    
    @FXML
    private void buttonBack(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = btnBack.getScene();
        scene.setRoot(root);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       updateComboDesignation();
    }
    
    private void updateComboDesignation(){
        UserBean ub = new UserBean();
        comboDesignation.setItems(ub.getAllDesignation());
    }
}
