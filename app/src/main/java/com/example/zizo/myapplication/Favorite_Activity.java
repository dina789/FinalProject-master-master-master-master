package com.example.zizo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Favorite_Activity extends AppCompatActivity {

    ListView listViewFav;
    // Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_);


        Intent intent=getIntent();

            listViewFav = (ListView) findViewById(R.id. listViewFav);
            // toolbar = (Toolbar) findViewById(R.id.toolbar);

            //setSupportActionBar(toolbar);







    }


}
