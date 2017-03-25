package com.example.egac.thechatapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

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

/**
 * Created by Egac on 1/4/2017.
 */

public class DnevniRaspored extends AppCompatActivity {

    RecyclerView rvMessage;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listItems;
    private Listitem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnevni);

        rvMessage  = (RecyclerView) findViewById(R.id.rvDnevni);
        rvMessage.setHasFixedSize(true);
        rvMessage.setLayoutManager(new LinearLayoutManager(this));

        DownloadTask task = new DownloadTask();
        task.execute("http://10.0.2.2/web2/json_get_data_dnevniRaspored.php");


//"http://api.openweathermap.org/data/2.5/weather?q=Osijek,hr&appid=c9ccd774a1f4cbe3ac7ccc7f5c684065"
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

                listItems = new ArrayList<>();

                JSONObject jsonObject = new JSONObject(result);

                String weatherInfo = jsonObject.getString("server_response");
                //String weatherInfo = jsonObject.getString("weather");

                Log.i("weather content", weatherInfo);

                JSONArray arr = new JSONArray(weatherInfo);

                for(int i = 0; i < arr.length(); i++){

                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = "";
                    String description = "";
                    String message = "";

                    main = jsonPart.getString("name");
                    description = jsonPart.getString("time");
                    message = jsonPart.getString("message");

                    if (main != "" && description != "" && message != "")
                    {
                        item= new Listitem(main, message, description);
                        listItems.add(i, item);
                    }

                    Log.i("name", jsonPart.getString("name") );
                    Log.i("time", jsonPart.getString("time"));
                    Log.i("message", jsonPart.getString("message"));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.i("website content", result);
            adapter = new MyAdapter(listItems, DnevniRaspored.this);
            rvMessage.setAdapter(adapter);
        }
    } //

}
