package com.example.rany.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imvBookResult);
        Bundle bundle = getIntent().getExtras();
        Picasso.get()
                .load(bundle.getString("image"))
                .into(imageView);

    }
}
