package com.example.egac.thechatapp;

import android.widget.ImageView;

/**
 * Created by Egac on 3/19/2017.
 */

public class ListitemNarudjbaLista {


       // private Imag image;
        private String tvState;
        private String tvCity;
        private String tvName;

        public ListitemNarudjbaLista(ImageView image , String tvState, String tvCity, String tvName) {

           // this.image = image;
            this.tvState = tvState;
            this.tvCity = tvCity;
            this.tvName = tvName;
        }


       // public String getImage() {
         //   return image;
       // }

        public String getState() {
            return tvState;
        }

        public String getCity() {
            return tvCity;
        }

        public String getName() {
            return tvName;
        }
    }

//}
