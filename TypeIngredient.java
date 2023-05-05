package tp5;

public class TypeIngredient {
    private String refType;
    private String nomType;

    public TypeIngredient(String refType, String nomType) {
        this.refType = refType;
        this.nomType = nomType;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
}
