package com.example.booksencyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Book> listBooks;

    public BooksAdapter(Context ctx, ArrayList<Book> listBooks) {
        this.ctx = ctx;
        this.listBooks = listBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_row_book, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = listBooks.get(position);

        holder.ivThumbnail.setImageResource(book.thumbnail);
        holder.tvTitle.setText(book.title);
    }

    @Override
    public int getItemCount() {
        return listBooks.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivThumbnail;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAbsoluteAdapterPosition();

            Book book = listBooks.get(position);
            String info = "Author: " + book.author + ", Price: " + book.price;

            Toast.makeText(ctx, info, Toast.LENGTH_LONG).show();
        }
    }
}
