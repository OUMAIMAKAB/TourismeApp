package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

public class Element {
    private String nameElement;
    private int imageElement;

    public Element(String nameElement, int imageElement) {
        this.nameElement = nameElement;
        this.imageElement = imageElement;
    }

    public String getNameElement() {
        return nameElement;
    }

    public int getImageElement() {
        return imageElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public void setImageElement(int imageElement) {
        this.imageElement = imageElement;
    }
}
