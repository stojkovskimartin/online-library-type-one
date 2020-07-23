package com.eimt.lab.EimtLab.data;

import com.eimt.lab.EimtLab.main.Library;

import java.util.List;

public interface Libraries {
    public List<Library> libList();
    public Library lib(int id);
    public void eraseLib(int id);
    public void newLib(Library library);
    public void appendLib(Library library);

}
