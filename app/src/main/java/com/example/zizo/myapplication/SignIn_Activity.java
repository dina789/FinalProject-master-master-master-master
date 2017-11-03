
package com.example.zizo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class SignIn_Activity extends  AppCompatActivity implements View.OnClickListener  {

    int PRIVATE_MODE = 0;
    //Button button_forgot;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    Button button_signIn;
    EditText edit_pass;
    EditText edit_name;
    Button button_signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);
        Intent Gotosignin  = getIntent();
        button_signIn.setBackgroundColor(Color.	BLUE);
        button_signIn.setTextColor(Color.BLACK);

        button_signUp = (Button) findViewById(R.id.button_signUp);
        button_signIn = (Button) findViewById(R.id.button_signUp);
        edit_pass = (EditText) findViewById(R.id.edit_pass);
        edit_name = (EditText) findViewById(R.id.edit_name);
        button_signUp.setOnClickListener(this);
        button_signIn.setOnClickListener(this);
    }


    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences =getSharedPreferences("LoginDetails", PRIVATE_MODE);
        boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isEmailEmpty || isPasswordEmpty;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.button_signUp:
                Intent goTo_SIGNUP = new Intent(SignIn_Activity.this, SignUp_Activity.class);
                startActivity(goTo_SIGNUP);
                // Do something
                break;
            case R.id.button_signIn:

                SharedPreferences sharedPreferences=getSharedPreferences("SHARED_PREF_NAME",0);
                String user = sharedPreferences.getString("user", null);
                Gson gson
                        =new Gson();






                UserDetails userFromShared = new Gson().fromJson(user, UserDetails .class);

                Intent MySearchintent = new Intent(SignIn_Activity.this, MainActivity.class);
                startActivity( MySearchintent);
                Toast.makeText(SignIn_Activity.this,"ahln w sahln "+ userFromShared.getedit_name().toString(),Toast.LENGTH_LONG).show();
        }}

    private class PRIVATE_MODE {
    }
};
//https://developer.android.com/studio/write/theme-editor.html
//https://html-color-codes.info/colors-from-image/#
//http://mrbool.com/android-onclick-event-how-to-handle-button-clicks/31739
//https://stackoverflow.com/questions/14162225/getting-text-from-password-field
//https://github.com/mohamedsawii/Gson-Json/blob/master/app/src/main/java/com/example/pc/myapplication/MainActivity.java
//https://html-color-codes.info/color-names/
//http://code2care.org/pages/how-to-change-android-button-color-using-xml-attribute-and-programatically-using-java/
//http://abhiandroid.com/programming/shared-preference imppppppportant
//https://stackoverflow.com/questions/26740185/android-login-registration-with-shared-preferences

//https://stackoverflow.com/questions/6718514/android-check-user-logged-in-before-else-start-login-activity