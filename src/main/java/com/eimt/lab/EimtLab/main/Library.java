package com.eimt.lab.EimtLab.main;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Library {
    private long id;

    @Size(min = 1,message = "*Book name is required")
    private String book;

    @PositiveOrZero(message = "*You entered a negative number")
    private int num;

    private int catInt;

    private Categorization catBook;
    private MultipartFile image;
    private String imgBook;

    public Library(){

    }
    public Library(long id,String book, int num, Categorization catBook, int catInt, String imgBook) {
        this.id = id;
        this.book = book;
        this.num=num;
        this.catBook = catBook;
        this.catInt = catInt;
        this.imgBook=imgBook;
    }


    public String getImgBook() {
        return imgBook;
    }

    public void setImgBook2(String imgBook) {
        this.imgBook = imgBook;
    }

    public void setImgBook(MultipartFile imgBook) {
        this.imgBook = imgBook.getOriginalFilename();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Categorization getCatBook() {
        return catBook;
    }

    public void setCatBook(Categorization catBook) {
        this.catBook = catBook;
    }

    public int getCatInt() {
        return catInt;
    }

    public void setCatInt(int catInt) {
        this.catInt = catInt;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile Image) {
        this.image = image;
    }

}
