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
public class DataOF {
    
    private DataCommande commande;
    
    private String numOF;
    
    private int id;
    
    private int quantite;
    
    private int semaine;
    
    private String dateExped;
    
    private DataProduit produit;



    public DataOF(String numOF, int id, int quantite, int semaine, String dateExped) {
        this.numOF = numOF;
        this.id = id;
        this.quantite = quantite;
        this.semaine = semaine;
        this.dateExped = dateExped;
    }

    public DataOF(String numOF, int quantite, int semaine, String dateExped) {
        this.numOF = numOF;
        this.quantite = quantite;
        this.semaine = semaine;
        this.dateExped = dateExped;
    }

    public DataOF(String numOF, int quantite, String dateExped) {
        this.numOF = numOF;
        this.quantite = quantite;
        this.dateExped = dateExped;
    }

    
    public DataCommande getCommande() {
        return commande;
    }

    public void setCommande(DataCommande commande) {
        this.commande = commande;
    }

    public String getNumOF() {
        return numOF;
    }

    public void setNumOF(String numOF) {
        this.numOF = numOF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public String getDateExped() {
        return dateExped;
    }

    public void setDateExped(String dateExped) {
        this.dateExped = dateExped;
    }
    
    public DataProduit getProduit() {
        return produit;
    }

    public void setProduit(DataProduit produit) {
        this.produit = produit;
    }
    
    
    
    
    
}
