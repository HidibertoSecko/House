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
        TextView precio = (TextView)view.findViewById(R.id.precios);
        TextView descripciones = (TextView)view.findViewById(R.id.descripciones);
        ImageView photo = (ImageView)view.findViewById(R.id.photo);
        TextView ciudad = (TextView)view.findViewById(R.id.ciudad);
        TextView region = (TextView)view.findViewById(R.id.region);
        TextView zona = (TextView)view.findViewById(R.id.zona);
        TextView baños = (TextView)view.findViewById(R.id.baños);
        TextView cuartos = (TextView)view.findViewById(R.id.cuartos);
        TextView living_area = (TextView)view.findViewById(R.id.living_area);
        TextView lot_area = (TextView)view.findViewById(R.id.lot_area);
        TextView servicios = (TextView)view.findViewById(R.id.servicios);
        TextView garaje = (TextView)view.findViewById(R.id.garaje);
        TextView año = (TextView)view.findViewById(R.id.año);

        Glide.with(context).load(items.get(i).getUrl()).centerCrop().into(photo);
        precio.setText(this.items.get(i).getTitle());
        descripciones.setText(this.items.get(i).getDescription​());
        region.setText(this.items.get(i).getDescription​());
        zona.setText(this.items.get(i).getDescription​());
        baños.setText(this.items.get(i).getDescription​());
        cuartos.setText(this.items.get(i).getDescription​());
        living_area.setText(this.items.get(i).getDescription​());
        lot_area.setText(this.items.get(i).getDescription​());
        garaje.setText(this.items.get(i).getDescription​());
        año.setText(this.items.get(i).getDescription​());



        return view;
    }

}
