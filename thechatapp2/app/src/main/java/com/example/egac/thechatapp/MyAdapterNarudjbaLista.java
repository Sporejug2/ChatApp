package com.example.egac.thechatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egac on 3/19/2017.
 */

public class MyAdapterNarudjbaLista extends RecyclerView.Adapter<MyAdapterNarudjbaLista.ViewHolder> {

    private List<Listitem> listitems;
    private Context context;

    public MyAdapterNarudjbaLista(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_narudjbalista, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override //bajndamo podatke
    public void onBindViewHolder(ViewHolder holder, int position) {

        Listitem listitem = listitems.get(position);

        holder.textViewHead.setText(listitem.getHead());
        holder.textViewDesc.setText(listitem.getDesc());
        holder.textViewTime.setText(listitem.getTime());

       // Glide.with(context).load(listitems.get(position).getImage()).into(holder.imageView);
       // holder.imageView.setImageResource(listitem.getImage());

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView imageView;
        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewTime;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.tvState);
            textViewDesc = (TextView) itemView.findViewById(R.id.tvCity);
            textViewTime = (TextView) itemView.findViewById(R.id.tvName);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void addItem(Listitem listitm, int index)
    {
        listitems.add(index, listitm);
        this.notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        listitems.remove(index);
        this.notifyItemRemoved(index);
    }

    public void updateList(ArrayList<Listitem> data)
    {
        if (listitems!=null && !listitems.isEmpty())
            listitems.clear();
        listitems.addAll(data);
        this.notifyDataSetChanged();
    }
}

