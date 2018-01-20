package com.example.chelsi.kcjhomework;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Chelsi on 1/14/2018.
 */

public class
BooksResponse {

    //@SerializedName("results")
    private ArrayList<Books> results;


    public ArrayList<Books> getResults(){
        return results;
    }

}

