/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lpe_soft.Lpe_Soft;
import lpe_soft.model.DataProduit;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class ProduitController implements Initializable {
    @FXML private MenuBar myMenuBar;
    @FXML private Button btnRecherche;
    @FXML private Button btnAjoutProduit;
    @FXML private Button btnAjoutFamille;
    @FXML private TextField tfCode;
    @FXML private TextField tfType;
    @FXML private ImageView  iView;
    @FXML private TableView<DataProduit> tableView;
    @FXML private TableColumn<DataProduit, String> Code;
    @FXML private TableColumn<DataProduit, String> Type;
    @FXML private TableColumn<DataProduit, Float> Prix;
    private ObservableList<DataProduit> personData = FXCollections.observableArrayList();
    DataProduit temp;
    Date lastClickTime;
    private Stage MainStage;
    
    //Recherche
    @FXML
    private void handleRecherche(ActionEvent event) throws IOException {
        if ((tfCode.getText().isEmpty() && tfType.getText().isEmpty())) {
            System.out.println("vide");
        }else{
            System.out.println("recherche");
        }
    }
    //Clic img for go home
    @FXML
    private void handleHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = iView.getScene();
        scene.setRoot(root);
    }
    //-------------//
    //Menu Accueil
    //-------------//
    @FXML
    private void handleHomeA(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }
    //-------------//
    //Menu Commande
    //-------------//
    @FXML
    private void handleRedigerCommande(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }

    //-------------//
    //Menu Facture
    //-------------//
    @FXML
    private void handleRedigerFacture(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Facture.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }

    //---------------//
    //Menu Livraison
    //---------------//
    @FXML
    private void handleRedigerLivraison(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Livraison.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }
    //---------------//
    //Menu Tab Commande
    //---------------//
    @FXML
    private void handleRedigerTabCommande(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TabCommande.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }
    //-------------//
    //Menu Produit
    //-------------//
    @FXML
    private void handleAddProduit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjoutProduit.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void handleConsulterProduit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Produit.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }

    //------------//
    //Menu Client
    //------------//
    @FXML
    private void handleAddClient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjoutClient.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void handleConsulterClient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = myMenuBar.getScene();
        scene.setRoot(root);
    }
    
    
    @FXML
    private void handleAddDesignation(ActionEvent event) throws IOException {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ProduitController.class.getResource("AjoutDesignation.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("file:src/ressources/logo.png"));
            // Set the person into the controller.
            AjoutDesignationController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
    }
    
    
    
    @FXML
    private void handleRowSelect() throws IOException {
        DataProduit row = tableView.getSelectionModel().getSelectedItem();
        if (row == null) {
            return;
        }
        if (row != temp) {
            temp = row;
            lastClickTime = new Date();
        } else if (row == temp) {
            Date now = new Date();
            long diff = now.getTime() - lastClickTime.getTime();
            if (diff < 300) { //another click registered in 300 millis
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Lpe_Soft.class.getResource("view/DetailProduit.fxml"));
                Parent root = FXMLLoader.load(getClass().getResource("DetailProduit.fxml"));
                DetailProduitController controller = loader.getController();
                controller.setProduit(row);
                Scene scene = myMenuBar.getScene();
                scene.setRoot(root);
            } else {
                lastClickTime = new Date();
            }
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Code.setCellValueFactory(new PropertyValueFactory<DataProduit, String>("code"));
        Type.setCellValueFactory(new PropertyValueFactory<DataProduit, String>("type"));
        Prix.setCellValueFactory(new PropertyValueFactory<DataProduit, Float>("prix"));

        personData.add(new DataProduit("35486", "Carte mère", (float) 154.2));
        personData.add(new DataProduit("85231", "Processeur", (float) 148.5));
        personData.add(new DataProduit("78521", "Carte graphique", (float) 752.1));
        personData.add(new DataProduit("15964", "Cable", (float) 15.1));

        tableView.setItems(getPersonData());
    }

    public ObservableList<DataProduit> getPersonData() {
        return personData;
    }
}
