package com.example.zizo.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zizo.myapplication.Adapters.Place_adapter;
import com.example.zizo.myapplication.DataModel.placemodel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView_fav;
    ListView listView_near;
    // ImageView logout;
    ImageView imageheart;
    ImageView imagepower;
    EditText edit_search;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent MySearchintent = getIntent();
        Intent i2 = getIntent();
        Intent i3 = getIntent();


        progressDialog = new ProgressDialog(MainActivity.this);
        listView_fav = (ListView) findViewById(R.id.listView_fav);
        listView_near = (ListView) findViewById(R.id.listView_near );
        edit_search = (EditText) findViewById(R.id. edit_search);
        // searsh = (ImageView) findViewById(R.id.imageView2);
        imageheart = (ImageView) findViewById(R.id.imageheart);
        imageheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotofav = new Intent(MainActivity.this, Favorite_Activity.class);
                startActivity(gotofav);
                finish();
            }
        });
        imagepower= (ImageView) findViewById(R.id. imagepower);
        imagepower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                //   finish();
                Intent gotosignin = new Intent(MainActivity.this, SignIn_Activity.class);
                startActivity(gotosignin);
                finish();
            }
        });


        edit_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               MainActivity.GetPlacesFormatAPI getPlacesFormatAPI = new MainActivity.GetPlacesFormatAPI();
//                maps.googleapis.com / maps / api / place / nearbysearch / jso
                String url = "n?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM";
                https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=" + type + "&keyword=cruise&key=AIzaSyA0lnpD55lQP6OE7UltnxNskewWcbfB4aE

                //executeWebService(url);
                getPlacesFormatAPI.execute(url);
            }
        });
    }


    class GetPlacesFormatAPI extends AsyncTask<String, Void, placemodel[]> {
        @Override
        protected void onPreExecute() {


            progressDialog.setMessage("Loading . . . ");
            progressDialog.show();
        }

        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }

        @Override
        protected placemodel[] doInBackground(String... url) {

            // String url = "http://api.themoviedb.org/3/discover/movie?api_key=be32430c9f675ed7df41fbeda2a0525a&language=en-US&sort_by=" + sortByVarible + "&page=1";
//                executeWebService(url);
            try {
                String s = run(url[0]);
                Log.d("yarab", s);
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                //mTextView.setText(jsonArray.toString());

                final placemodel[] PlaceModels;
                PlaceModels = new Gson().fromJson(jsonArray.toString(), placemodel[].class);
                return PlaceModels;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;


        }

        @Override
        protected void onPostExecute(final placemodel[] PlaceModels) {

            progressDialog.dismiss();
            if (PlaceModels != null) {


                Place_adapter PlaceAdapter = new Place_adapter(MainActivity.this, PlaceModels);
                listView_near.setAdapter(PlaceAdapter);
                listView_near.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                        Toast.makeText(MainActivity.this, PlaceModels[i].getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Place_adapter.class);
                        intent.putExtra("placeModel" , (Serializable) PlaceModels[i]);
                        startActivity(intent);
                    }
                    // Toast.makeText(MainActivity.this, PlaceModels[i].getTitle(), Toast.LENGTH_SHORT).show();



                });

            }
        }
    }



}


// AIzaSyByy9wb2_lp8zUZSlDBVFgisRmyAVIsjXM


////void setSubmitButtonEnabled (boolean enabled)

//http://mrbool.com/how-to-customize-different-buttons-in-android/27747
//https://drive.google.com/drive/folders/0BxCn49aM_sqMMDVqa1FPYWpsOXc
//https://html-color-codes.info/colors-from-image/
//https://developer.android.com/guide/topics/search/search-dialog.html
//https://stackoverflow.com/questions/24163708/logout-clear-sharedpreferences