package com.example.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

class DescripcionHome {
    private Context context;
    private List<Item> items;

    public DescripcionHome(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }


    public int getCount() {
        return this.items.size();
    }

    public Object getItem(int i) {
        return this.items.get(i);
    }

    public long getItemId(int i) {
        return this.items.get(i).getId​();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflate = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflate.inflate(R.layout.descripcion_home, null);
        }
        TextView titulo = (TextView)view.findViewById(R.id.precio);
        TextView description = (TextView)view.findViewById(R.id.description);
        ImageView image = (ImageView)view.findViewById(R.id.imagesource);
        Glide.with(context).load(items.get(i).getUrl()).centerCrop().into(image);
        titulo.setText(this.items.get(i).getTitle());
        description.setText(this.items.get(i).getDescription​());

        return view;
    }

}
