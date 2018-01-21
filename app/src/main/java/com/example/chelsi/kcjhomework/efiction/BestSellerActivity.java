package com.example.chelsi.kcjhomework.efiction;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.chelsi.kcjhomework.*;
import com.example.chelsi.kcjhomework.efictionbooks.BooksEFiction;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BestSellerActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.nytimes.com/svc/books/v3/";
    private ArrayList<BooksEFiction> booksEFictionArrayList;
    private String title;
    private String author;
    private String image;
    List<String> firstImages = new ArrayList<>();
    private FrameLayout fictionFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_seller);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BooksService booksService = retrofit.create(BooksService.class);
        Call<FictionResponse> booksResponseCall = booksService.getEbookFiction();
        Log.d("MTREQUEST", booksResponseCall.request().toString());
        booksResponseCall.enqueue(new Callback<FictionResponse>() {
            @Override
            public void onResponse(Call<FictionResponse> call, Response<FictionResponse> response) {
                FictionResponse fictionResponse = response.body();
                List<Lists> lists = fictionResponse.getResults().getLists();
                List<Books> booksList = lists.get(1).getBooks();

                for (int i = 0; i < booksList.size(); i++) {
                    title = booksList.get(i).getTitle();
                    author = booksList.get(i).getAuthor();
                    image = booksList.get(i).getBookImage();
                    firstImages.add(image);
                }

                HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.horizontal_cycle);
                MyAdapter myAdapter = new MyAdapter(firstImages, getBaseContext());
                pager.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<FictionResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

}
