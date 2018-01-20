package com.example.chelsi.kcjhomework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Chelsi on 1/14/2018.
 */

public interface BooksService {
    @GET("svc/books/v3/lists.json?list-name=hardcover-fiction&api-key=")
    Call<BooksResponse> getBooks(@Path("apiKey")String key);

}
