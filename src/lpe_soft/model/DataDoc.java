package lpe_soft.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Chetan
 */
public class DataDoc {

    private StringProperty code, client,type;

    private int date;

    public DataDoc(String Code, String Client, String Type, int date) {
        this.code =  new SimpleStringProperty(Code);
        this.client = new SimpleStringProperty(Client);
        this.type = new SimpleStringProperty(Type);
        this.date = date;
    }
    
    //Setters
    public void setDate(int date) {
        this.date = date;
    }
    public void setCode(String code) {
        this.code.set(code);
    }
    public void setType(String type) {
        this.type.set(type);
    }
    public void setClient(String client) {
        this.client.set(client);
    }

    //Getters
    public int getDate() {
        return date;
    }
    public String getCode() {
        return code.get();
    }
    public String getClient() {
        return client.get();
    }
    public String getType() {
        return type.get();
    }
    
    //Property
    public StringProperty codeProperty() {
        return code;
    }   
    public StringProperty clientProperty() {
        return client;
    }
    public StringProperty typeProperty() {
        return type;
    }

}