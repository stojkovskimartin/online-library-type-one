package com.eimt.lab.EimtLab.data;

import com.eimt.lab.EimtLab.main.Categorization;

import java.util.List;

public interface CategorizationData {
    public List<Categorization> catList();
    public Categorization cat(int id);
    public void eraseCat(int id);
    public void newCat();
    public void appendCat(Categorization categorization);
}
