package com.example.chelsi.kcjhomework.efiction;

/**
 * Created by joannesong on 1/20/18.
 */

public class FictionResponse {


    private String status;
    private String copyright;
    private int numResults;
    private Results results;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getNumResults() {
        return numResults;
    }

    public Results getResults() {
        return results;
    }
}
