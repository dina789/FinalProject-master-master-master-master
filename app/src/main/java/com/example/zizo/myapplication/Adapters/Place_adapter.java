package com.example.zizo.myapplication.Adapters;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zizo.myapplication.DataModel.placemodel;
import com.example.zizo.myapplication.R;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

//Not yet ..
public class Place_adapter extends ArrayAdapter<placemodel> {

    public Place_adapter(@NonNull Context context, @NonNull placemodel[] objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.row_placemodel_,parent,false);
        }
        placemodel placemodel = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);


        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?photoreference=" + placemodel.getPhotos().get(0).getPhotoReference() + "&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM").into(image);


        RatingBar rating=(RatingBar)convertView.findViewById(R.id.ratingBar);
        rating.setRating(placemodel.getRating());

        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(placemodel.getName());

        TextView openinghours = (TextView) convertView.findViewById(R.id.openinghours);
        openinghours.setText((CharSequence) placemodel.getOpeningHours());
        TextView types = (TextView) convertView.findViewById(R.id.type);

        String type="[ ";
        for (String s : placemodel.getTypes()) {
            type=type+s+" , ";
        }
        type=type+" ]";
        Log.d(TAG, "getView: "+type);
        types.setText(type);

        return convertView;

    }
}
//https://stackoverflow.com/questions/41012640/android-how-to-handle-ratingbar-in-custom-adapter
//https://console.developers.google.com/apis/api/static-maps-backend.googleapis.com/overview?project=robust-service-182615&hl=ar&duration=PT1H