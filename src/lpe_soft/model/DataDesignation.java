/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpe_soft.model;

/**
 *
 * @author ambie
 */
public class DataDesignation {
    
    private long ID;
    
    private String value;

    public DataDesignation(long ID, String value) {
        this.ID = ID;
        this.value = value;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    
}
