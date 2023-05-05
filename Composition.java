package tp5;

public class Composition {
    private int refComposition;
    private double quantiteComposition;
    private String refRecette;
    private String refIngredient;

    public Composition(int refComposition, double quantiteComposition, String refRecette, String refIngredient) {
        this.refComposition = refComposition;
        this.quantiteComposition = quantiteComposition;
        this.refRecette = refRecette;
        this.refIngredient = refIngredient;
    }

   




	// Getters and setters
    public int getRefComposition() {
        return refComposition;
    }

    public void setRefComposition(int refComposition) {
        this.refComposition = refComposition;
    }

    public double getQuantiteComposition() {
        return quantiteComposition;
    }

    public void setQuantiteComposition(double quantiteComposition) {
        this.quantiteComposition = quantiteComposition;
    }

    public String getRecette() {
        return refRecette;
    }

    public void setRecette(String recette) {
        this.refRecette = recette;
    }

    public String getIngredient() {
        return refIngredient;
    }

    public void setIngredient(String ingredient) {
        this.refIngredient = ingredient;
    }
    public String toString() {
    	return"le ref du Composition: "+getRefComposition()+" ,la quantité: "+getQuantiteComposition()+",pour la Recette: "+getRecette();
    }
}
