package com.example.chelsi.kcjhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.nytimes.com/svc/books/v3/";
    private ArrayList<Books> booksArrayList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    BooksAdapter booksAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BooksService booksService = retrofit.create(BooksService.class);
        Call<BooksResponse> booksResponseCall = booksService.getBooks("bae0d227af2c497080cd36480cca8266");
        booksResponseCall.enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                Log.d("response", "onResponse: working"+ response.toString());

                booksArrayList = response.body().getResults();
                booksAdapter = new BooksAdapter(booksArrayList);
                recyclerView.setAdapter(booksAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        return true;
    }
}
