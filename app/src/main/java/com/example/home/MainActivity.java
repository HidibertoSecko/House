package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
    }

    public void descripcionhome(View view){
        Intent descripcion = new Intent(this, des_home.class);
        startActivity(descripcion);
    }
    public void ubicacion(View view){
        Intent ubicacion = new Intent(this,ubicacion.class);
        startActivity(ubicacion);
    }

    public void registrarhouse(View view){
        Intent register = new Intent(this, RegisterHome.class);
        startActivity(register);
    }

    private void loadComponents() {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        final ListView list = (ListView)this.findViewById(R.id.list_main);
        final ArrayList<Item> list_data = new ArrayList<Item>();
        client.get(Data.HOST+Data.REGISTER_HOME, params, new JsonHttpResponseHandler(){

         @Override
         public void onSuccess(int statusCode, Header[] headers, JSONObject response){
             try {
                JSONArray list = (JSONArray) response.get("Search");
                for(int i=0; i < list.length(); i++){
                    JSONObject itemJson = list.getJSONObject(i);
                    String photo = itemJson.getString("photo");
                    String precio = itemJson.getString("precio");
                    String property_descrytion = itemJson.getString("property_descryption");
                    String zone = itemJson.getString("zone");
                    String estado = itemJson.getString("region");

                    Item item =new Item(photo, precio,  property_descrytion, zone, estado);
                    list_data.add(item);
                }
                 ListAdapter adapter = new ListAdapter(MainActivity.this, list_data);

             } catch (JSONException e) {
                 e.printStackTrace();
             }

         }

            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
               // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                try {
                    //JSONArray data = response.getJSONArray("data");
                    for(int i=0;i<response.length();i++){
                        Item p = new Item(i);
                        JSONObject obj = response.getJSONObject(i);
                        //Toast.makeText(MainActivity.this,""+response.length(),Toast.LENGTH_SHORT).show();
                        p.id = i;
                        p.photo = obj.getString("photo");
                        p.property_descrytion​ = obj.getString("property_descryption");
                        p.precio = obj.getString("precio");
                        p.zone = obj.getString("zone");
                        p.estado = obj.getString("region");
                        list_data.add(p);
                    }
                    ListAdapter adapter = new ListAdapter(MainActivity.this, list_data);
                    list.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            public void OnFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse){

            }
        });

    }
}

