package com.eimt.lab.EimtLab.main;

public class Categorization {

    private long id;
    private String categorizationName;
    private String categorization;

    public Categorization(){

    }

    public Categorization(long id, String categorizationName, String categorization) {
        this.id = id;
        this.categorizationName = categorizationName;
        this.categorization = categorization;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategorizationName() {
        return categorizationName;
    }

    public void setCategorizationName(String categorizationName) {
        this.categorizationName = categorizationName;
    }

    public String getCategorization() {
        return categorization;
    }

    public void setCategorization(String categorization) {
        this.categorization = categorization;
    }
}
