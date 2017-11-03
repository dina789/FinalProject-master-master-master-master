package com.example.zizo.myapplication.DataModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dodo on 10/27/2017.
 */

public class FavorietModel implements Serializable {


    String name="";
    private String number="";
    private String address="";
    private static final long serialVersionUID = 46543445;



    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getAddress()
    {
        return address;
    }

    float rating;
    String types;

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    String opening_hours;

    private List<photo> photos;

    public List<photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<photo> photos) {
        this.photos = photos;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }




    public class photo{
        private String photo_reference;
        private String html_attributions;
        private float height;
        private float width;

        public String getPhoto_reference() {
            return photo_reference;
        }

        public void setPhoto_reference(String photo_reference) {
            this.photo_reference = photo_reference;
        }

        public String getHtml_attributions() {
            return html_attributions;
        }

        public void setHtml_attributions(String html_attributions) {
            this.html_attributions = html_attributions;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        public float getWidth() {
            return width;
        }

        public void setWidth(float width) {
            this.width = width;
        }
    }}



