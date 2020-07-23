package com.eimt.lab.EimtLab.services;

import com.eimt.lab.EimtLab.main.Categorization;

import java.util.List;

public interface ServiceCategorization {
    public List<Categorization> catList();
    public Categorization cat(int id);
    public void eraseCat(int id);
    public void newCat();
    public void appendCat(Categorization categorization);
}
