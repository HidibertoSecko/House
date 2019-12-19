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

public class MainActivityDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle);

        loadDetalles();
    }

    private void loadDetalles() {
        AsyncHttpClient detalle = new AsyncHttpClient();
        RequestParams paramsdetalle = new RequestParams();
        ListView listdetalle = (ListView)this.findViewById(R.id.list_detalle);
        final ArrayList<Itemdetalle> list_detalle = new ArrayList<>();

        detalle.get(Data.HOST+Data.REGISTER_HOME, paramsdetalle, new JsonHttpResponseHandler(){

            public void onSuccess(int statuCode, Header[] headers, JSONObject response){
                try {
                    JSONArray list = (JSONArray) response.get("Search");

                        JSONObject itemJson = list.getJSONObject(1);
                        String foto = itemJson.getString("photo");

                        Itemdetalle itemdetalle = new Itemdetalle(foto);
                        list_detalle.add(itemdetalle);

                    ListAdapterdetalle adapterdetalle = new ListAdapterdetalle(MainActivityDetalle.this, list_detalle);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                try {
                    //JSONArray data = response.getJSONArray("data");
                    for(int i=0;i<response.length();i++){
                        Itemdetalle p = new Itemdetalle(i);
                        JSONObject obj = response.getJSONObject(i);
                        //Toast.makeText(MainActivity.this,""+response.length(),Toast.LENGTH_SHORT).show();
                        p.id = i;
                        p.foto = obj.getString("photo");
                        list_detalle.add(p);
                    }
                    ListAdapterdetalle adapter = new ListAdapterdetalle(MainActivityDetalle.this, list_detalle);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
