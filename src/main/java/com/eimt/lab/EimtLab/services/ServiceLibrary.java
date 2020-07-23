package com.eimt.lab.EimtLab.services;

import com.eimt.lab.EimtLab.main.Library;

import java.util.List;

public interface ServiceLibrary {
    public List<Library> libList();
    public Library lib(int id);
    public void eraseLib(int id);
    public void appendLib(Library library);
}
