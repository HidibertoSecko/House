package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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

    private void loadComponents() {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        final ListView list = (ListView)this.findViewById(R.id.list_main);
        final ArrayList<Item> list_data = new ArrayList<Item>();
        client.get("http://192.168.100.138:8000/api/v1.0/homes", params, new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                Toast.makeText(MainActivity.this, "PUFF", Toast.LENGTH_SHORT).show();
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

