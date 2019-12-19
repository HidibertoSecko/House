package com.example.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterdetalle extends BaseAdapter {
    private Context context2;
    private List<Itemdetalle> items2;

    public ListAdapterdetalle(Context context2, ArrayList<Itemdetalle> items2){
            this.context2 = context2;
            this.items2 = items2;
    }

    @Override
    public int getCount() {
        return this.items2.size();
    }

    @Override
    public Object getItem(int i) {
        return this.items2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.items2.get(i).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null) {
            LayoutInflater inflate = (LayoutInflater)
                    this.context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflate.inflate(R.layout.item_detalle, null);
        }

        ImageView image = (ImageView)view.findViewById(R.id.fotodetalle);

        Glide.with(context2).load(items2.get(i).getFoto()).centerCrop().into(image);
    return view;}
}
