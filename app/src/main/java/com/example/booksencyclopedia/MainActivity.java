package com.example.booksencyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> listBooks;
    RecyclerView rvBooks;
    BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBooks = new ArrayList<>();

        Book book1 = new Book();
        book1.title = "Beginning Android 4 Application Development";
        book1.author = "Wei-Meng Lee";
        book1.price = 50.99;
        book1.thumbnail = R.drawable.book1;

        Book book2 = new Book();
        book2.title = "Harry Potter";
        book2.author = "J.K. Rowling";
        book2.price = 40.61;
        book2.thumbnail = R.drawable.book2;

        listBooks.add(book1);
        listBooks.add(book2);

        rvBooks = findViewById(R.id.rvBooks);

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(llManager);

        adapter = new BooksAdapter(this, listBooks);
        rvBooks.setAdapter(adapter);
    }
}