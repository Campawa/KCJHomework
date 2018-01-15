package com.example.chelsi.kcjhomework;

import java.util.ArrayList;

/**
 * Created by Chelsi on 1/13/2018.
 */

public class Books {
    private int cover;
    private String title;
    private String author;
    private ArrayList<Ranks> ranks_history;


    public int getCover() {
        return cover;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<Ranks> getRanks_history() {
        return ranks_history;
    }
}
