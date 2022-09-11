package core.organism;

public enum CrossoverType {
    ONE_POINT("crossing a point"),
    MULTI_POINT("multiple points"),
    UNIFORM("crossing uniform");

    private CrossoverType(String description){
        this.description = description;
    }   

    private String description;

    public String getDescription(){
        return this.description;
    }
}
