package com.example.egac.thechatapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class Narudjba extends Activity {

    EditText name , time , message;
    String Name , Time , Message;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.narudjba);
        name = (EditText) findViewById(R.id.registercall_name);
        time = (EditText) findViewById(R.id.registercall_time);
        message = (EditText) findViewById(R.id.registercall_poruka);

    }

    public void register_register(View v){
        Name = name.getText().toString();
        Time = time.getText().toString();
        Message = message.getText().toString();
        BackGround b = new BackGround();
        b.execute(Name, Time, Message);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String time = params[1];
            String message = params[2];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://10.0.2.2/test/web2/registercall.php");
                String urlParams = "name="+name+"&time="+time+"&message="+message;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }
                is.close();
                httpURLConnection.disconnect();

                return data;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("")){
                s="Data saved successfully.";
            }
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }

    public void pregled (View v){
        Intent i = new Intent();
        i.setClass(this, NarudjbaChatActivity.class);
        this.startActivity(i);
    }

}


