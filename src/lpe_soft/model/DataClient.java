package lpe_soft.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Chetan
 */
public class DataClient {

    private StringProperty code,nom,correspondant,email,telephone;

    public DataClient(String code, String nom, String correspondant,String email, String telephone) {
        this.code =  new SimpleStringProperty(code);
        this.nom = new SimpleStringProperty(nom);
        this.correspondant = new SimpleStringProperty(correspondant);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
    }
    
    //Setters
    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }
    public void setCode(String code) {
        this.code.set(code);
    }
    public void setNom(String nom) {
        this.nom.set(nom);
    }
    public void setCorrespondant(String correspondant) {
        this.correspondant.set(correspondant);
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    
    //Getters
    public String getTelephone() {
        return telephone.get();
    }
    public String getCode() {
        return code.get();
    }
    public String getNom() {
        return nom.get();
    }
    public String getCorrespondant() {
        return correspondant.get();
    }
    public String getEmail() {
        return email.get();
    }
    
    //Property
    public StringProperty codeProperty() {
        return code;
    }
    public StringProperty nomProperty() {
        return nom;
    }
    public StringProperty telephoneProperty() {
        return telephone;
    }
    public StringProperty correspondantProperty() {
        return correspondant;
    }
    public StringProperty emailProperty() {
        return email;
    }
}