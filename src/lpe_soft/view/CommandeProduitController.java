package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lpe_soft.model.DataClient;
import lpe_soft.model.DataCommande;
import lpe_soft.model.DataOF;
import lpe_soft.model.DataProduit;
import lpe_soft.model.UserBean;

public class CommandeProduitController implements Initializable {

    private DataClient client;

    @FXML private Button btnEnd;
    @FXML private Button btnAdd;
    @FXML private Button btnBack;
    @FXML private DatePicker dateField;
    @FXML private TableView tableProducts;
    @FXML private ComboBox comboProducts;
    @FXML private TextField quantiteField;
    @FXML private TextField ofField;
    @FXML private Label ofInfo;
    @FXML private Label quantiteInfo;
    @FXML private Label dateInfo;
    @FXML private TableColumn<DataOF, String> produit;
    @FXML private TableColumn<DataOF, String> quantite;
    @FXML private TableColumn<DataOF, String> of;
    @FXML private TableColumn<DataOF, String> dateLivr;
    
    private ArrayList<DataOF> ofs;
    
    private DataCommande commande;
    
    @FXML
    private void handleEnd (ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void handleAdd(ActionEvent event) throws IOException {
        if (comboProducts.getValue() != null) {
            if (!quantiteField.getText().equals("") && Integer.parseInt(quantiteField.getText()) != 0){
                if (!ofField.getText().equals("")){
                    if (dateField.getValue() != null && dateField.getValue().isAfter(LocalDate.now())){
                        DataOF of = new DataOF(ofField.getText(),
                                Integer.parseInt(quantiteField.getText()),
                                dateField.getValue().format(DateTimeFormatter.ISO_WEEK_DATE));
                        of.setProduit((DataProduit) comboProducts.getValue());
                        ofs.add(of);
                        dateInfo.setText("");
                        ofInfo.setText("");
                        quantiteInfo.setText("");
                        updateTable();
                    }else {
                        dateInfo.setText("Veuillez entrer une date valide.");
                    }
                } else{
                    ofInfo.setText("Veuillez entrer un numéro d'OF.");
                }
            }else{
                quantiteInfo.setText("Veuillez entrer une quantité valide.");
            }
        }
    }
    
    @FXML
    private void handleEdit(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void handleCreateProduct(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ofs = new ArrayList<>();
        produit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        of.setCellValueFactory(new PropertyValueFactory<>("numOF"));
        dateLivr.setCellValueFactory(new PropertyValueFactory<>("dateExped"));
        updateComboProducts();
        updateTable();
    }

    public DataClient getClient() {
        return client;
    }

    public void setClient(DataClient client) {
        this.client = client;
    }
    
    private void updateComboProducts(){
        UserBean ub = new UserBean();
        comboProducts.setItems(ub.getAllProducts());
    }

    private void updateTable() {        
        tableProducts.setItems(FXCollections.observableArrayList(ofs));
        tableProducts.refresh();
    }
    
}
