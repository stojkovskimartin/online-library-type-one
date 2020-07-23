package com.eimt.lab.EimtLab.services;

import com.eimt.lab.EimtLab.data.CategorizationData;
import com.eimt.lab.EimtLab.data.Libraries;
import com.eimt.lab.EimtLab.main.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLibraryImpl implements ServiceLibrary{

    private Libraries libraries;

    @Autowired
    public ServiceLibraryImpl(Libraries libraries){
        this.libraries = libraries;
    }

    @Override
    public List<Library> libList() {
        return libraries.libList();
    }

    @Override
    public Library lib(int id) {
        return libraries.lib(id);
    }

    @Override
    public void eraseLib(int id) {
    libraries.eraseLib(id);
    }

    @Override
    public void appendLib(Library library) {
    libraries.appendLib(library);
    }
}
