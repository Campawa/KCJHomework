package com.example.chelsi.kcjhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.nytimes.com/svc/books/v3/";

    private ArrayList<Books> booksArrayList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BooksAdapter booksAdapter;
    private FrameLayout fragment_container;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.options_item:
                Toast.makeText(this, "options selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_item:
                Toast.makeText(this, "Search item selected..", Toast.LENGTH_SHORT).show();
            break;
            case R.id.help_item:
                Toast.makeText(this, "I can only do so much...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, BookCovers.class);
                startActivity(intent);
            break;
            case R.id.FAQ:
                Toast.makeText(this, "Frequently Asked Questions", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        fragment_container = findViewById(R.id.fragment_container);

        NYTFragment nytFragment = new NYTFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, nytFragment);
        fragmentTransaction.commit();

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
}
