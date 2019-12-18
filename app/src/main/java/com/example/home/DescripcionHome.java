package com.example.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class DescripcionHome extends BaseAdapter {
    private Context contex;
    private ArrayList<item_home> item;

    public DescripcionHome(Context context, ArrayList<item_home> item){
        this.contex= context;
        this.item = item;
    }


    @Override
    public int getCount() {
        return this.item.size();
    }

    @Override
    public Object getItem(int i) {
        return this.item.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.item.get(i).getId​();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflate = (LayoutInflater)
                    this.contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflate.inflate(R.layout.descripcion_home,null);
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

        Glide.with(contex).load(item.get(i).getPhoto()).centerCrop().into(photo);
        precio.setText(this.item.get(i).getPrecio());
        descripciones.setText(this.item.get(i).getDescription​());
        ciudad.setText(this.item.get(i).getCity());
        region.setText(this.item.get(i).getRegion());
        zona.setText(this.item.get(i).getZona());
        baños.setText(this.item.get(i).getBaños());
        cuartos.setText(this.item.get(i).getCuartos());
        living_area.setText(this.item.get(i).getLiving_area());
        lot_area.setText(this.item.get(i).getLot_area());
        servicios.setText(this.item.get(i).getServicios_basicos());
        garaje.setText(this.item.get(i).getGaraje());
        año.setText(this.item.get(i).getAño_construccion());

        return view;
    }

}
