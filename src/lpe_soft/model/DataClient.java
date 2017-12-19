package lpe_soft.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Chetan
 */
public class DataClient {

  private StringProperty codeClient, nom, telephone, fax, email, correspondant, incoterm, eori, reglement, transport, autorisationPP, numeroOF, adresseFacturation, adresseLivraison;
  private long ID;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
  
  
  
  
    public DataClient(String code, String nom, String correspondant,String email, String telephone) {
        this.codeClient =  new SimpleStringProperty(code);
        this.nom = new SimpleStringProperty(nom);
        this.correspondant = new SimpleStringProperty(correspondant);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
    }

    public DataClient(long ID, String codeClient, String nom, String telephone, String fax, String email, String correspondant, String incoterm, String eori, String reglement, String transport, String autorisationPP, String numeroOF, String adresseFacturation, String adresseLivraison) {
        this.ID = ID;
        this.codeClient = new SimpleStringProperty(codeClient);
        this.nom = new SimpleStringProperty(nom);
        this.telephone = new SimpleStringProperty(telephone);
        this.fax = new SimpleStringProperty(fax);
        this.email = new SimpleStringProperty(email);
        this.correspondant = new SimpleStringProperty(correspondant);
        this.incoterm = new SimpleStringProperty(incoterm);
        this.eori = new SimpleStringProperty(eori);
        this.reglement = new SimpleStringProperty(reglement);
        this.transport = new SimpleStringProperty(transport);
        this.autorisationPP = new SimpleStringProperty(autorisationPP);
        this.numeroOF = new SimpleStringProperty(numeroOF);
        this.adresseFacturation = new SimpleStringProperty(adresseFacturation);
        this.adresseLivraison = new SimpleStringProperty(adresseLivraison);
    }

    
    
    public DataClient() {
        codeClient = new SimpleStringProperty();
        nom = new SimpleStringProperty();
        telephone = new SimpleStringProperty();
        fax = new SimpleStringProperty();
        email = new SimpleStringProperty();
        correspondant = new SimpleStringProperty();
        incoterm = new SimpleStringProperty();
        eori = new SimpleStringProperty();
        reglement = new SimpleStringProperty();
        transport = new SimpleStringProperty();
        autorisationPP = new SimpleStringProperty();
        numeroOF = new SimpleStringProperty();
        adresseFacturation = new SimpleStringProperty();
        adresseLivraison = new SimpleStringProperty();
    }

    public String getCodeClient() {
        return codeClient.get();
    }

    public String getNom() {
        return nom.get();
    }

    public String getTelephone() {
        return telephone.get();
    }

    public String getFax() {
        return fax.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getCorrespondant() {
        return correspondant.get();
    }

    public String getIncoterm() {
        return incoterm.get();
    }

    public String getEori() {
        return eori.get();
    }

    public String getReglement() {
        return reglement.get();
    }

    public String getTransport() {
        return transport.get();
    }

    public String getAutorisationPP() {
        return autorisationPP.get();
    }

    public String getNumeroOF() {
        return numeroOF.get();
    }

    public String getAdresseFacturation() {
        return adresseFacturation.get();
    }

    public String getAdresseLivraison() {
        return adresseLivraison.get();
    }

    
    
    
    
    
    
    
    public StringProperty adresseLivraisonProperty(){
        return adresseLivraison;
    }
    
    public StringProperty adresseFacturationProperty(){
        return adresseFacturation;
    }
    
    public StringProperty numeroOFProperty(){
        return numeroOF;
    }
    
    public StringProperty autorisationPPProperty(){
        return autorisationPP;
    }
    
    public StringProperty transportProperty(){
        return transport;
    }
    
    public StringProperty reglementProperty(){
        return reglement;
    }
    
    public StringProperty eoriProperty(){
        return eori;
    }
    
    public StringProperty incotermProperty(){
        return incoterm;
    }
    
    public StringProperty correspondantProperty(){
        return correspondant;
    }
   
    public StringProperty emailProperty(){
        return email;
    }
    
    public StringProperty faxProperty(){
        return fax;
    }
    
    public StringProperty telephoneProperty(){
        return telephone;
    }
   
    
    public StringProperty nomProperty(){
        return nom;
    }
    
    public StringProperty codeClientProperty(){
        return codeClient;
    }
    
    
    
    public void setCodeClient(StringProperty codeClient) {
        this.codeClient = codeClient;
    }

    public void setNom(StringProperty nom) {
        this.nom = nom;
    }

    public void setTelephone(StringProperty telephone) {
        this.telephone = telephone;
    }

    public void setFax(StringProperty fax) {
        this.fax = fax;
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }

    public void setCorrespondant(StringProperty correspondant) {
        this.correspondant = correspondant;
    }

    public void setIncoterm(StringProperty incoterm) {
        this.incoterm = incoterm;
    }

    public void setEori(StringProperty eori) {
        this.eori = eori;
    }

    public void setReglement(StringProperty reglement) {
        this.reglement = reglement;
    }

    public void setTransport(StringProperty transport) {
        this.transport = transport;
    }

    public void setAutorisationPP(StringProperty autorisationPP) {
        this.autorisationPP = autorisationPP;
    }

    public void setNumeroOF(StringProperty numeroOF) {
        this.numeroOF = numeroOF;
    }

    public void setAdresseFacturation(StringProperty adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public void setAdresseLivraison(StringProperty adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    
    
    public String toString(){
        return " - codeClient: " +codeClient+
        " - nom: " +nom+
        " - telephone: " +telephone+
        " - fax: " +fax+
        " - email: " +email+
        " - correspondant: " +correspondant+
        " - incoterm: " +incoterm+
        " - reglement: " +reglement+
        " - transport: " +transport+
        " - autorisationPP: " +autorisationPP+
        " - numeroOF: " +numeroOF+
        " - adresseFacturation: " +adresseFacturation+
        " - adresseLivraison: " +adresseLivraison;
    }

}