package com.example.chelsi.kcjhomework;

import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by Chelsi on 1/14/2018.
 */

public interface BooksService {
    @GET("")
    Call<BooksResponse> getBooks();

}
