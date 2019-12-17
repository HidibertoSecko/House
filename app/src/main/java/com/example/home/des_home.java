package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.home.utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class des_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des_home);

        loadDescripcion();
    }

    private void loadDescripcion() {
        AsyncHttpClient house = new AsyncHttpClient();
        RequestParams datos = new RequestParams();
        final ListView lista = (ListView)this.findViewById(R.id.list_descripcion);
        final ArrayList<item_home> list_des = new ArrayList<item_home>();
        house.get(Data.HOST+Data.REGISTER_HOME, datos, new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                try {
                    //JSONArray data = response.getJSONArray("data");
                    for(int i=0;i<response.length();i++){
                        item_home casa = new item_home();
                        JSONObject obj = response.getJSONObject(i);
                        //Toast.makeText(MainActivity.this,""+response.length(),Toast.LENGTH_SHORT).show();
                        casa.id = i;
                        casa.city= obj.getString("city");
                        casa.region = obj.getString("region");
                        casa.zona = obj.getString("zone");
                        casa.precio = obj.getString("precio");
                        casa.description​ = obj.getString("property_descryption");
                        casa.baños = obj.getString("bedrooms");
                        casa.cuartos = obj.getString("badrooms");
                        casa.living_area = obj.getString("living_area");
                        casa.lot_area = obj.getString("lot_area");
                        casa.piscina = obj.getString("piscina");
                        casa.photo = obj.getString("photo");
                        casa.servicios_basicos = obj.getString("servicios");
                        casa.garaje = obj.getString("garaje");
                        casa.año_construccion = obj.getString("año_construccion");
                        list_des.add(casa);
                    }
                    DescripcionHome descrip = new DescripcionHome(des_home.this, list_des);
                    lista.setAdapter(descrip);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            public void OnFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse){

            }
        });
    }
}
