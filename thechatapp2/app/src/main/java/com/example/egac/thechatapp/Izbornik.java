package com.example.egac.thechatapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Izbornik extends Activity {

    Button kalendar, karta;
    Button Naručen,Pregledat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.izbornik);

        kalendar = (Button) findViewById(R.id.kalendar);
        Naručen = (Button) findViewById(R.id.naručiti);
        Pregledat = (Button) findViewById(R.id.pregledati);
    }

    public void Kalendar (View v){
        startActivity(new Intent(this,Kalendar.class));
    }

    public void naruđba (View v){
        Intent i = new Intent();
        i.setClass(this, Narudjba.class);
        this.startActivity(i);
    }

    public void pregled (View v){
        Intent i = new Intent();
        i.setClass(this, Odabir.class);
        this.startActivity(i);
    }

    public void igrica (View v){
        startActivity(new Intent(this,Igrica.class));
    }


}