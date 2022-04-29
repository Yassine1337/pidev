/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP
 */
public class Materiels {
    int id,quantite;
    String nom,fournisseur,categorie;

    public Materiels(Object id, Object nom, Object fournisseur, Object categorie, Object quantite) {
        this.id =(int) id;
        this.nom =(String) nom;
        this.fournisseur =(String) fournisseur;
        this.categorie =(String) categorie;
        this.quantite = (int) quantite;
    }

    public Materiels( Object nom, Object fournisseur, Object categorie, Object quantite) {
        
        this.nom =(String) nom;
        this.fournisseur =(String) fournisseur;
        this.categorie =(String) categorie;
        this.quantite = (int) quantite;
    }

    public Materiels() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Materiels{" + "id=" + id + ", quantite=" + quantite + ", nom=" + nom + ", fournisseur=" + fournisseur + ", categorie=" + categorie + '}';
    }

    
    
    
    
}
