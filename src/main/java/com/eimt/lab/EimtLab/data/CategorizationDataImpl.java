package com.eimt.lab.EimtLab.data;

import com.eimt.lab.EimtLab.main.Categorization;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategorizationDataImpl implements CategorizationData {

    private List<Categorization> categorizations;
    public CategorizationDataImpl()
    {
        categorizations = new ArrayList<>();
    }


    @Override
    public List<Categorization> catList() {
        return categorizations;
    }

    @Override
    public Categorization cat(int id) {
        Categorization categorization=categorizations.get(id);
        return categorization;
    }

    @Override
    public void eraseCat(int id) {
    categorizations.remove(id);
    }

    @Override
    public void newCat() {

    }

    @Override
    public void appendCat(Categorization categorization) {
    categorizations.add(categorization);
    }
}
