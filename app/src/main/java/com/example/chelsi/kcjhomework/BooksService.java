package com.example.chelsi.kcjhomework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Chelsi on 1/14/2018.
 */

public interface BooksService {
//<<<<<<< HEAD
//    @GET("book/v1/")
//    Call<BooksResponse> getBooks(@Path("apiKey")String key,@Query("q")String name,@Query("parameter")String title);
//=======
    @GET("lists/best-sellers/history.json")
    Call<BooksResponse> getBooks(@Query("api-key") String apiKey);


//>>>>>>> 5c487f3d49e02c187315b67bede0e778a86923dc

}
