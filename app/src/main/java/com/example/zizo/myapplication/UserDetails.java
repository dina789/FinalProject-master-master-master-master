package com.example.zizo.myapplication;

/**
 * Created by Zizo on 10/26/2017.
 */

class UserDetails {

    String edit_name,edit_email,BUTTON_IMAGE,date;
    int edit_pass;

    public UserDetails(String username, int password, String email) {
        this.edit_name = username;
        this.edit_pass = password;
        this.edit_email = email;
    }
    public String getedit_name() {

        return edit_name;
    }

    public void setedit_name(String username) {
        this.edit_name = username;
    }

    public int getedit_pass() {
        return edit_pass;
    }

    public void setedit_pass(int password) {
        this.edit_pass= password;
    }

    public String getedit_email() {
        return edit_email;
    }

    public void setedit_email(String email) {
        this.edit_email = email;
    }
    public String getBUTTON_IMAGE() {
        return BUTTON_IMAGE;
    }

    public void setBUTTON_IMAGE(String imageurl) {
        this.BUTTON_IMAGE = imageurl;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String birthdate) {
        this. date = birthdate;
    }


}




 //https://www.youtube.com/watch?v=nHmPErsoe64