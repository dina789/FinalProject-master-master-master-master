package com.example.zizo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;


public class SignUp_Activity extends AppCompatActivity {


    static final String SHARED_PREF_NAME = "user";
    static final int REQUEST_PICK_IMAGE = 55;
    FloatingActionButton btnSelectImage;
    ImageView imageView;
    EditText edit_name, edit_email, edit_pass, date;
    Button button_SIGNUP, button_SIGN_IN;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        } else {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_pass = (EditText) findViewById(R.id.edit_pass);
        edit_name = (EditText) findViewById(R.id.edit_name);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnSelectImage = (FloatingActionButton) findViewById(R.id.btnSelectImage);
        button_SIGN_IN = (Button) findViewById(R.id.button_SIGN_IN);
        button_SIGNUP = (Button) findViewById(R.id.button_SIGNUP);

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  Intent gallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                                                  gallery.setType("image/*");
                                                  startActivityForResult(gallery, 55);

                                              }
                                          });
                button_SIGNUP.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View view) {

                                                         if (edit_email.getText() != null && edit_pass.getText() != null) {

                                                             // 4.a check if username and password are OK
                                                             if (edit_email.getText().toString().equals(edit_email) &&
                                                                     edit_pass.getText().toString().equals(edit_pass)) {


                                                                 UserDetails user = new UserDetails(edit_name.getText().toString(), Integer.parseInt(edit_pass.getText().toString()),
                                                                         edit_email.getText().toString());

                                                                 SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                                                                 SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                 Gson gson = new Gson();
                                                                 String theUser = gson.toJson(user);
                                                                 Toast.makeText(SignUp_Activity.this, theUser, Toast.LENGTH_LONG).show();
                                                                 editor.putString("UserDetails", theUser);
                                                                 editor.apply();
                                                                 Intent intent = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                                                                 startActivity(intent);
                                                                 finish();
                                                             } else

                                                             {
                                                                 Toast.makeText(SignUp_Activity.this, "Worng Email !", Toast.LENGTH_SHORT).show();
                                                             }
                                                         }
                                                     }
                                                 });

                        button_SIGN_IN.setOnClickListener(new View.OnClickListener() {
                            @Override

                            public void onClick(View view) {
                                Intent Gotosignin = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                                startActivity(Gotosignin);


                            }
                        });


    }
}


//    https://stackoverflow.com/questions/10347184/difference-and-when-to-use-getapplication-getapplicationcontext-getbasecon


//final image link :https://stackoverflow.com/questions/5309190/android-pick-images-from-gallery
//http://abhiandroid.com/ui/datepicker
//https://stackoverflow.com/questions/9770122/android-upload-image-from-gallery-to-server
//https://github.com/futuresimple/android-floating-action-button
//https://www.android-examples.com/pick-image-from-gallery-in-android-programmatically/
//http://programmerguru.com/android-tutorial/how-to-pick-image-from-gallery/
/// //http://codetheory.in/android-pick-select-image-from-gallery-with-intents/


//https://github.com/dina789/finalsignnn/blob/master/app/src/main/java/hk/ust/cse/comp107x/all_sign_up/MainActivity.java
///working <code></code>https://stackoverflow.com/questions/26740185/android-login-registration-with-shared-preferences
//https://stackoverflow.com/questions/17969752/android-wrong-password-or-username-message-box-display-error