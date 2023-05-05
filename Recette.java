package tp5;

import java.util.ArrayList;

public class Recette {
    private String refRecette;
    private String nomRecette;
    private String descriptifRecette;
    private int caloriesRecette;
    private String difficulte;
    private int tempsPreparation;
    private int tempsCuisson;
    private int nbPersonnes;
    private ArrayList<Ingredient> ingredients;
    
    public Recette(String refRecette, String nomRecette, String descriptifRecette, int caloriesRecette, String difficulte, int tempsPreparation, int tempsCuisson, int nbPersonnes) {
        this.refRecette = refRecette;
        this.nomRecette = nomRecette;
        this.descriptifRecette = descriptifRecette;
        this.caloriesRecette = caloriesRecette;
        this.difficulte = difficulte;
        this.tempsPreparation = tempsPreparation;
        this.tempsCuisson = tempsCuisson;
        this.nbPersonnes = nbPersonnes;
        this.ingredients = new ArrayList<Ingredient>();
    }
    
    // Getters et Setters
    public String getRefRecette() {
        return refRecette;
    }
    
    public void setRefRecette(String refRecette) {
        this.refRecette = refRecette;
    }
    
    public String getNomRecette() {
        return nomRecette;
    }
    
    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }
    
    public String getDescriptifRecette() {
        return descriptifRecette;
    }
    
    public void setDescriptifRecette(String descriptifRecette) {
        this.descriptifRecette = descriptifRecette;
    }
    
    public int getCaloriesRecette() {
        return caloriesRecette;
    }
    
    public void setCaloriesRecette(int caloriesRecette) {
        this.caloriesRecette = caloriesRecette;
    }
    
    public String getDifficulte() {
        return difficulte;
    }
    
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
    
    public int getTempsPreparation() {
        return tempsPreparation;
    }
    
    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }
    
    public int getTempsCuisson() {
        return tempsCuisson;
    }
    
    public void setTempsCuisson(int tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }
    
    public int getNbPersonnes() {
        return nbPersonnes;
    }
    
    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }
    
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ref recette:          ").append(refRecette).append("\n");
        sb.append("Nom recette:          ").append(nomRecette).append("\n");
        sb.append("Descriptif recette:   ").append(descriptifRecette).append("\n");
        sb.append("Calories recette:     ").append(caloriesRecette).append("\n");
        sb.append("Difficulte:           ").append(difficulte).append("\n");
        sb.append("Temps preparation:    ").append(tempsPreparation).append("\n");
        sb.append("Temps cuisson:        ").append(tempsCuisson).append("\n");
        sb.append("Nombre personnes:     ").append(nbPersonnes).append("\n");
        return sb.toString();
    }
}