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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
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
import lpe_soft.model.DataDoc;

/**
 * FXML Controller class
 *
 */
public class HomeController implements Initializable {

    @FXML private MenuBar myMenuBar;
    @FXML private Button btnRecherche;
    @FXML private TextField tfCode;
    @FXML private TextField tfClient;
    @FXML private CheckBox  commande;
    @FXML private CheckBox  facture;
    @FXML private CheckBox  livraison;
    @FXML private CheckBox  AR;
    @FXML private ImageView  iView;
    @FXML private TableView<DataDoc> tableView;
    @FXML private TableColumn<DataDoc, String> Code;
    @FXML private TableColumn<DataDoc, String> Client;
    @FXML private TableColumn<DataDoc, String> Type;
    @FXML private TableColumn<DataDoc, String> Date;
    private Stage MainStage;

    private ObservableList<DataDoc> personData = FXCollections.observableArrayList();
    DataDoc temp;
    Date lastClickTime;
    private boolean boolC,boolF,boolL;
    
    //Recherche
    @FXML
    private void handleRecherche(ActionEvent event) throws IOException {
        if ((tfCode.getText().isEmpty() && tfClient.getText().isEmpty() && !boolC && !boolF && !boolL)) {
            System.out.println("vide");
        }else{
            System.out.println("recherche");
        }
    }
    @FXML
    private void handleCBC(ActionEvent event) throws IOException {
        if(boolC){
            boolC=false;
        }else{
            boolC=true;
        }
    }
    @FXML
    private void handleCBF(ActionEvent event) throws IOException {
        if(boolF){
            boolF=false;
        }else{
            boolF=true;
        }
    }
    @FXML
    private void handleCBL(ActionEvent event) throws IOException {
        if(boolL){
            boolL=false;
        }else{
            boolL=true;
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
    private void handleRowSelect() throws IOException {
        DataDoc row = tableView.getSelectionModel().getSelectedItem();
        if (row == null) {
            return;
        }
        if (row != temp) {
            temp = row;
            lastClickTime = new Date();
        } else if (row == temp) {
            Date now = new Date();
            long diff = now.getTime() - lastClickTime.getTime();
            if (diff < 300) { 
                String type = row.getType();
                if (type=="Facture"){
                    Parent root = FXMLLoader.load(getClass().getResource("DetailFacture.fxml"));
                    Scene scene = myMenuBar.getScene();
                    scene.setRoot(root);
                }
                else if (type=="Bon de Livraison"){
                    Parent root = FXMLLoader.load(getClass().getResource("DetailLivraison.fxml"));
                    Scene scene = myMenuBar.getScene();
                    scene.setRoot(root);
                }
                else if (type=="Commande"){
                    //TODO
                }
                else if (type=="Accusé de Réception"){
                    Parent root = FXMLLoader.load(getClass().getResource("DetailAR.fxml"));
                    Scene scene = myMenuBar.getScene();
                    scene.setRoot(root);
                }
                
            } else {
                lastClickTime = new Date();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Code.setCellValueFactory(new PropertyValueFactory<DataDoc, String>("code"));
        Client.setCellValueFactory(new PropertyValueFactory<DataDoc, String>("client"));
        Date.setCellValueFactory(new PropertyValueFactory<DataDoc, String>("date"));
        Type.setCellValueFactory(new PropertyValueFactory<DataDoc, String>("type"));

        personData.add(new DataDoc("CF015284", "UT","Commande", 2017));
        personData.add(new DataDoc("CF015284", "UT","Accusé de Réception", 2017));
        personData.add(new DataDoc("CF657419", "SE","Facture", 2016));
        personData.add(new DataDoc("CF008532", "SA","Commande", 2011));
        personData.add(new DataDoc("CF115237", "SE","Bon de Livraison", 2019));
        personData.add(new DataDoc("CF699532", "UT","Bon de Livraison", 2012));
        personData.add(new DataDoc("CF008521", "BR","Facture", 2013));
        personData.add(new DataDoc("CF774499", "BR","Bon de Livraison", 2017));
        personData.add(new DataDoc("CF111153", "UT","Commande", 2016));
        personData.add(new DataDoc("CF259314", "EE","Commande", 2018));
        personData.add(new DataDoc("CF332211", "EE","Commande", 2015));
        personData.add(new DataDoc("CF414169", "EE","Facture", 2016));

        tableView.setItems(getPersonData());
    }

    public ObservableList<DataDoc> getPersonData() {
        return personData;
    }

}
