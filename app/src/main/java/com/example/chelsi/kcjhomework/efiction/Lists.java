package com.example.chelsi.kcjhomework.efiction;

import java.util.List;

public class Lists {
    private int listId;
    private String listName;
    private String listNameEncoded;
    private String displayName;
    private String updated;
    private String listImage;
    private int listImageWidth;
    private int listImageHeight;
    private List<Books> books;

    public int getListId() {
        return listId;
    }

    public String getListName() {
        return listName;
    }

    public String getListNameEncoded() {
        return listNameEncoded;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUpdated() {
        return updated;
    }

    public String getListImage() {
        return listImage;
    }

    public int getListImageWidth() {
        return listImageWidth;
    }

    public int getListImageHeight() {
        return listImageHeight;
    }

    public List<Books> getBooks() {
        return books;
    }
}
