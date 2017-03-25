package com.example.egac.thechatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egac on 2/9/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Listitem> listitems;
    private Context context;

    public MyAdapter(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View   v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override //bajndamo podatke
    public void onBindViewHolder(ViewHolder holder, int position) {

        Listitem listitem = listitems.get(position);

        holder.textViewHead.setText(listitem.getHead());
        holder.textViewDesc.setText(listitem.getDesc());
        holder.textViewTime.setText(listitem.getTime());
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewTime;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.tvHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            textViewTime = (TextView) itemView.findViewById(R.id.tvTime);
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
