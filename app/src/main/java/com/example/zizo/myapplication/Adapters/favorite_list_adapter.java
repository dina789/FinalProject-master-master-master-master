package com.example.zizo.myapplication.Adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zizo.myapplication.DataModel.FavorietModel;
import com.example.zizo.myapplication.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Dodo on 10/27/2017.
 */

public class favorite_list_adapter extends ArrayAdapter<FavorietModel> {


    public favorite_list_adapter(@NonNull Context context, @NonNull FavorietModel[] objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.row_favourite_,parent,false);
        }
        FavorietModel favModel = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);


        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?photoreference="+favModel.getPhotos().get(position).getPhoto_reference()+"&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM").into(imageView);
        ;



        TextView text_name=(TextView) convertView.findViewById(R.id.text_rest);
        text_name.setText(favModel.getName());

        RatingBar ratingBar=(RatingBar)convertView.findViewById(R.id.ratingBar);
        ratingBar.setRating(favModel.getRating());


        TextView text_open=(TextView)convertView.findViewById(R.id.text_open);
        text_open.setText(favModel. getOpening_hours()+"");



        return convertView;


        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
    }
}

//http://theopentutorials.com/tutorials/android/listview/android-custom-listview-with-image-and-text-using-arrayadapter/
//https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
//http://www.jsonschema2pojo.org/ http://www.jsonschema2pojo.org/
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM



