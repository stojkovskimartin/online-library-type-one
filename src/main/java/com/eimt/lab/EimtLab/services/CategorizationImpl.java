package com.eimt.lab.EimtLab.services;

import com.eimt.lab.EimtLab.data.CategorizationData;
import com.eimt.lab.EimtLab.main.Categorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationImpl implements ServiceCategorization {

    private CategorizationData categorizationData;

    @Autowired
    public CategorizationImpl(CategorizationData categorizationData)
    {
        this.categorizationData = categorizationData;
    }


    @Override
    public List<Categorization> catList() {
        return categorizationData.catList();
    }

    @Override
    public Categorization cat(int id) {
        return categorizationData.cat(id);
    }

    @Override
    public void eraseCat(int id) {
    categorizationData.eraseCat(id);
    }

    @Override
    public void newCat() {
    }

    @Override
    public void appendCat(Categorization categorization) {
    categorizationData.appendCat(categorization);
    }
}
