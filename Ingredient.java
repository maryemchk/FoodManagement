package tp5;

public class Ingredient {
    private String refIngredient;
    private String nomIngredient;
    private String refType;

    public Ingredient(String refIngredient, String nomIngredient, String refType) {
        this.refIngredient = refIngredient;
        this.nomIngredient = nomIngredient;
        this.refType = refType;
    }

    public String getRefIngredient() {
        return refIngredient;
    }

    public void setRefIngredient(String refIngredient) {
        this.refIngredient = refIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }
    public String toString() {
    	return "Ingredient de nom : "+getNomIngredient()+" ,son reference est: "+getRefIngredient()+" et son refernce type est: "+getRefType();
    }
}
