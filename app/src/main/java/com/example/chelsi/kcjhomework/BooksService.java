package com.example.chelsi.kcjhomework;

import com.example.chelsi.kcjhomework.efiction.FictionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Chelsi on 1/14/2018.
 */

public interface BooksService {

    @GET("lists/best-sellers/history.json")
    Call<BooksResponse> getBooks(@Query("api-key") String apiKey);

    @GET("lists.json?list=hardcover-fiction&weeks-on-list=1&api-key=bae0d227af2c497080cd36480cca8266")
    Call<BooksResponse> getHardcoverFiction();

    @GET("lists/overview.json?api-key=bae0d227af2c497080cd36480cca8266")
    Call<FictionResponse> getEbookFiction();


}
