package com.example.chelsi.kcjhomework;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chelsi on 1/13/2018.
 */

public class BooksViewHolder extends RecyclerView.ViewHolder {

    ImageView book;
    TextView title;
    TextView author;

    public BooksViewHolder(View itemView) {
        super(itemView);

        book = itemView.findViewById(R.id.bookCover);
        title = itemView.findViewById(R.id.bookTitle);
        author = itemView.findViewById(R.id.bookAuthor);
    }

    public void bind(Books books){
        book.setImageResource(books.getCover());
        title.setText(books.getTitle());
        author.setText(books.getAuthor());
    }
}
