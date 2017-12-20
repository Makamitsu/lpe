package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lpe_soft.model.DataDesignation;
import lpe_soft.model.UserBean;

public class AjoutDesignationController implements Initializable {

    @FXML private Button btnBack;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private TextField Designation;
    @FXML private ComboBox comboDesi;
    @FXML private Label labelInfo;
    private Stage dialogStage;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    @FXML
    private void handleDelete() {
        UserBean ub = new UserBean();
        DataDesignation selected = (DataDesignation) comboDesi.getValue();
        if (!ub.isDesignationUsed(selected)){
            // Suppression possible
            ub.deleteDesignation(selected);
        }
    }
    @FXML
    private void ButtonAddDesignation (ActionEvent event) throws IOException{
        UserBean ub = new UserBean();
        if (Designation.getText().equals("")) {
            labelInfo.setTextFill(Color.web("#dd0000"));
            labelInfo.setText("Veuillez entrer une désignation.");
            return;
        }
        if (ub.addDesignation(Designation.getText())){
            labelInfo.setTextFill(Color.web("#00dd00"));
            labelInfo.setText(Designation.getText() + " a bien été ajouté.");
            Designation.setText("");
            updateComboBox();
        }else {
            labelInfo.setTextFill(Color.web("#dd0000"));
            labelInfo.setText(Designation.getText() + " n'a pas pu être ajouté.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateComboBox();
        System.err.println(labelInfo.getText());
    }
    
    private void updateComboBox(){
        UserBean ub = new UserBean();
        this.comboDesi.setItems(ub.getAllDesignation());
    }
    
}
