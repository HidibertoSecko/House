package com.example.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items;

    public ListAdapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int i) {
        return this.items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.items.get(i).getId​();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflate = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflate.inflate(R.layout.item_ui, null);
        }
        TextView precio = (TextView)view.findViewById(R.id.precio);
        TextView description = (TextView)view.findViewById(R.id.description);
        ImageView image = (ImageView)view.findViewById(R.id.imagesource);
        TextView zone = (TextView)view.findViewById(R.id.zona);
        TextView estado= (TextView)view.findViewById(R.id.estado);



        Glide.with(context).load(items.get(i).getPhoto()).centerCrop().into(image);
        precio.setText(this.items.get(i).getPrecio());
        description.setText(this.items.get(i).getProperty_descrytion​​());
        zone.setText(this.items.get(i).getZone());
        estado.setText(this.items.get(i).getEstado());

        return view;
    }
}
