package com.example.egac.thechatapp;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kage-kun on 11.02.2017..
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    CardView cv;
    TextView name, desc, time;

    public ViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvItem);
        name = (TextView) itemView.findViewById(R.id.tvHead);
        desc = (TextView) itemView.findViewById(R.id.tvDesc);
        time = (TextView) itemView.findViewById(R.id.tvTime);
    }

}
