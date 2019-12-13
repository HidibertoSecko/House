package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        final ListView des = (ListView)this.findViewById(R.id.list_descripcion);
        final ArrayList<Item> list_des = new ArrayList<Item>();
        client.get("http://192.168.100.138:8000/api/v1.0/homes?id=5df309b7307139007810952b", params, new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                try {
                    //JSONArray data = response.getJSONArray("data");
                    for(int i=0;i<response.length();i++){
                        Item p = new Item();
                        JSONObject obj = response.getJSONObject(i);
                        //Toast.makeText(MainActivity.this,""+response.length(),Toast.LENGTH_SHORT).show();
                        p.id = i;
                        p.title = obj.getString("precio");
                        p.description​ = obj.getString("property_descryption");
                        p.url = obj.getString("photo");
                        list_des.add(p);
                    }
                    DescripcionHome descrip= new DescripcionHome(des_home.this, list_des);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            public void OnFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse){

            }
        });
    }
}
