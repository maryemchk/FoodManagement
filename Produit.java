package tp5;

import java.sql.Date;

public class Produit {
    private String refProduit;
    private String descriptifProduit;
    private Date datePeremption;
    private int quantiteProduit;
    private double prixProduit;
    private String  rangement;
    private String ingredient;

    public Produit(String refProduit, String descriptifProduit, Date datePeremption, int quantiteProduit,
                   double prixProduit, String rangement, String ingredient) {
        this.refProduit = refProduit;
        this.descriptifProduit = descriptifProduit;
        this.datePeremption = datePeremption;
        this.quantiteProduit = quantiteProduit;
        this.prixProduit = prixProduit;
        this.rangement = rangement;
        this.ingredient = ingredient;
    }

    // Getters and setters
    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    public String getDescriptifProduit() {
        return descriptifProduit;
    }

    public void setDescriptifProduit(String descriptifProduit) {
        this.descriptifProduit = descriptifProduit;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getRangement() {
        return rangement;
    }

    public void setRangement(String rangement) {
        this.rangement = rangement;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }


    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient.getNomIngredient();
    }
}
