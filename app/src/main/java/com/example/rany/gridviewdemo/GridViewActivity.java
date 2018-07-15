package com.example.rany.gridviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.rany.gridviewdemo.adapter.BookAdapter;
import com.example.rany.gridviewdemo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    private GridView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.gvBooks);

        final List<Book> bookList = new ArrayList<>();

        for(int i = 1; i <= 50 ; i++){
            bookList.add(new Book(i, " Title "+ i,"https://vignette.wikia.nocookie.net/2007scape/images/7/7a/Mage%27s_book_detail.png/revision/latest?cb=20180310083825"));
        }

        BookAdapter adapter = new BookAdapter(this, bookList);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, bookList.get(position).getTitle(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GridViewActivity.this,
                        DetailActivity.class);
                intent.putExtra("image", bookList.get(position).getImage());
                startActivity(intent);
            }
        });


    }
}
