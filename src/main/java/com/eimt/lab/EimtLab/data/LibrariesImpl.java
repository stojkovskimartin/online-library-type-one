package com.eimt.lab.EimtLab.data;

import com.eimt.lab.EimtLab.main.Library;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibrariesImpl implements Libraries{

    private List<Library> libraries;

    public LibrariesImpl(){
        libraries=new ArrayList<>();

    }

    @Override
    public List<Library> libList() {
        return libraries;
    }

    @Override
    public Library lib(int id) {
        Library library = libraries.get(id);
        return library;
    }

    @Override
    public void eraseLib(int id) {
    libraries.remove(id);
    }

    @Override
    public void newLib(Library library) {
    }

    @Override
    public void appendLib(Library library) {
    libraries.add(library);
    }
}
