package com.example.chelsi.kcjhomework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Chelsi on 1/14/2018.
 */

public interface BooksService {
    @GET("lists/best-sellers/history.json")
    Call<BooksResponse> getBooks(@Query("api-key") String apiKey);

    @GET("lists/best-sellers/history.json")
    Call<RanksReponse> getRanks(@Query("api-key") String apiKey);
}
