package com.example.egac.thechatapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NarudjbaLista extends Activity {

    RecyclerView rvMessage;
    private RecyclerView.Adapter adapter;
    private List<ListitemNarudjbaLista> listItems;
    private Listitem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narudjba_lista);

        rvMessage  = (RecyclerView) findViewById(R.id.recyclerView2);
        rvMessage.setHasFixedSize(true);
        rvMessage.setLayoutManager(new LinearLayoutManager(this));

        DownloadTask task = new DownloadTask();
        task.execute("http://10.0.2.2/test/web2/json_get_narudjbaLista.php");

    }


    public class DownloadTask extends AsyncTask<String, Void, String> {// na backgrount thread

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                String messages = "";

                JSONObject jsonObject = new JSONObject(result);

                String weatherInfo = jsonObject.getString("server_response");
                //String weatherInfo = jsonObject.getString("weather");

                Log.i("weather content", weatherInfo);

                JSONArray arr = new JSONArray(weatherInfo);
                listItems = new ArrayList<>();

                for(int i = 0; i < arr.length(); i++){

                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = "";
                    String description = "";
                    String poruka = "";

                    main = jsonPart.getString("name");
                    description = jsonPart.getString("time");
                    poruka = jsonPart.getString("poruka");

                    Log.i("name", jsonPart.getString("name") );
                    Log.i("time", jsonPart.getString("time"));
                    Log.i("poruka", jsonPart.getString("poruka"));

                    if (main != "" && description != "" && poruka != "")
                    {
                        item= new Listitem(main, poruka, description);
                       // listItems.add(i, item);
                    }


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.i("website content", result);
            //adapter = new MyAdapter(listItems, NarudjbaLista.this);
            rvMessage.setAdapter(adapter);

        }
    } //
    public void clicked (View v){
        startActivity(new Intent(this,Odgovor.class));
    }
}

