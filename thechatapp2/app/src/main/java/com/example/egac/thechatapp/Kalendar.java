package com.example.egac.thechatapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by Egac on 12/14/2016.
 */

public class Kalendar extends Activity implements View.OnClickListener {

    Button btnTime, btnDate;
    TextView tvTime, tvDate, savTime, savDate;

    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;


    Calendar calendar = Calendar.getInstance();
    SharedPreferences sharedPreferences , sharedPreferences2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalendar);

        sharedPreferences = this.getSharedPreferences("com.example.egac.thechatapp" , Context.MODE_PRIVATE);
        sharedPreferences2 = this.getSharedPreferences("com.example.egac.thechatapp" , Context.MODE_PRIVATE);



        btnTime = (Button) findViewById(R.id.btnTime);
        btnTime.setOnClickListener(this);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnDate.setOnClickListener(this);

        tvTime = (TextView) findViewById(R.id.textView);
        tvDate = (TextView) findViewById(R.id.textView2);

       savTime = (TextView) findViewById(R.id.textView5);
        savDate = (TextView) findViewById(R.id.textView6);

    }

    @Override
    public void onClick(View v) {

        calendar = Calendar.getInstance();



        switch (v.getId()) {

            case R.id.btnTime: {

                timePickerDialog = new TimePickerDialog(Kalendar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar timeCalendar = Calendar.getInstance();
                        timeCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        timeCalendar.set(Calendar.MINUTE, minute);

                        String timeString = DateUtils.formatDateTime(Kalendar.this, timeCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME);

                       sharedPreferences2.edit().putString("Vrijeme:" , timeString).apply();

                        String timeString2 = sharedPreferences2.getString("Vrijeme:" , "");

                        tvTime.setText("Vrijeme: " + timeString);

                       savTime.setText("Vrijeme: "+ timeString2);

                        Log.i("Datum" , timeString2);

                        /*

                         String dateString = DateUtils.formatDateTime(Kalendar.this, dateCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE);

                        sharedPreferences.edit().putString("Datum:" , dateString).apply();

                        String dateString2 = sharedPreferences.getString("Datum:" , "");

                        tvDate.setText("Datum:" + dateString);

                        savDate.setText("Datum" + dateString2);

                        Log.i("Datum" , dateString2);
                         */


                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE), android.text.format.DateFormat.is24HourFormat(Kalendar.this));

                timePickerDialog.show();

                break;
            }
            case R.id.btnDate: {

                datePickerDialog = new DatePickerDialog(Kalendar.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Calendar dateCalendar = Calendar.getInstance();
                        dateCalendar.set(Calendar.YEAR, year);
                        dateCalendar.set(Calendar.MONTH, month);
                        dateCalendar.set(Calendar.YEAR, dayOfMonth);

                        String dateString = DateUtils.formatDateTime(Kalendar.this, dateCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE);

                        sharedPreferences.edit().putString("Datum:" , dateString).apply();

                        String dateString2 = sharedPreferences.getString("Datum:" , "");

                        tvDate.setText("Datum:" + dateString);

                        savDate.setText("Datum" + dateString2);

                        Log.i("Datum" , dateString2);



                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
                break;

            }


        }
    }

    public void Izbornik (View v){
        startActivity(new Intent(this,Kalendar.class));
    }
}
