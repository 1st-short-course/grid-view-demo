package com.example.rany.gridviewdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rany.gridviewdemo.R;
import com.example.rany.gridviewdemo.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends BaseAdapter {

    private static final String TAG = "ooooo";
    private List<Book> bookList = new ArrayList<>();
    private Context context;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bookList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.book_item, parent, false
        );

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        ImageView imvBook = view.findViewById(R.id.imvBook);

        Book book = bookList.get(position);

        Log.e(TAG, "getView: "+book.getTitle());

        tvTitle.setText(book.getTitle());
        Picasso.get()
                .load(book.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .resize(200, 200)
                .centerCrop()
                .into(imvBook);

        return view;
    }
}
