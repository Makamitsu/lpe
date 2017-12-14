package lpe_soft.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Chetan
 */
public class DataProduit {

    private StringProperty code,type;

    private float prix;

    public DataProduit(String code, String type, float prix) {
        this.code =  new SimpleStringProperty(code);
        this.type = new SimpleStringProperty(type);
        this.prix = prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public float getPrix() {
        return prix;
    }

    public String getCode() {
        return code.get();
    }

    public String getType() {
        return type.get();
    }
    
    public StringProperty codeProperty() {
        return code;
    }
    
    public StringProperty typeProperty() {
        return type;
    }
}