package com.example.zizo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zizo.myapplication.DataModel.placemodel;
import com.squareup.picasso.Picasso;


public class details extends AppCompatActivity {
   

    placemodel placeModel;
    ImageView image_details ;
    ImageView imageViewmap;
    TextView text_name,textView_type,textView7_open,ratingBar;
    float rate=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        Intent getDetails = getIntent();
        placeModel = (placemodel) getDetails.getSerializableExtra("placeModel");


//google static map

        ImageView imagemap = (ImageView) findViewById(R.id.imagemap);

        
        Picasso.with(this).load("https://maps.googleapis.com/maps/api/staticmap?center=40.714728,-73.998672&zoom=12&size=400x400&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM");
        ImageView image_details = (ImageView) findViewById(R.id.image_details );

        Picasso.with(this).load("maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM" ).into(image_details);


        text_name= (TextView) findViewById(R.id.text_name);
        text_name.setText(placeModel.getName());


        TextView  textView_type = (TextView) findViewById(R.id. textView_type);

        textView_type.setText((CharSequence) placeModel.getTypes());


        textView7_open = (TextView) findViewById(R.id.textView7_open);
        textView7_open.setText((CharSequence) placeModel.getOpeningHours());

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setRating(rate);
//still 3yzaaaa dataaaa






    }



    public void onimageView12Click (View view)
    {
        //Back Code
        Intent intent = new Intent(details.this , MainActivity.class);
        startActivity(intent);
    }

    {

    }

    


    // AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM
//https://maps.googleapis.com/maps/api/staticmap?center=40.714728,-73.998672&zoom=12&size=400x400&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM
//https://stackoverflow.com/questions/35810229/how-to-display-and-set-click-event-on-back-arrow-on-toolbar
//https://stackoverflow.com/questions/36060373/google-places-api-return-a-single-type-car-repair
//https://developers.google.com/maps/documentation/android-api/current-place-tutorial
}