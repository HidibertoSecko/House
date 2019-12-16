package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.home.utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.w3c.dom.Text;

import cz.msebera.android.httpclient.Header;

public class Registrar_zonas extends AppCompatActivity {
    private Button zregistrar;
    private static Context zone=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_zonas);


        zregistrar=findViewById(R.id.zregistrar);
        zregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senRegisterZona();
                listhouse(v);
            }

            private void senRegisterZona() {
                TextView ciudadz = findViewById(R.id.zcity);
                TextView namezonez =findViewById(R.id.znamezome);
                TextView superficie_totalz =findViewById(R.id.zsuperficie_total);
                TextView latitudz =findViewById(R.id.zlatitud);
                TextView longitudz =findViewById(R.id.zlongitud);


                AsyncHttpClient zone = new AsyncHttpClient();
                RequestParams paramsZona = new RequestParams();
                paramsZona.add("city",ciudadz.getText().toString());
                paramsZona.add("namezome",namezonez.getText().toString());
                paramsZona.add("superficie_total",superficie_totalz.getText().toString());
                paramsZona.add("latitud",latitudz.getText().toString());
                paramsZona.add("longitud",longitudz.getText().toString());
                zone.post(Data.HOST + Data.REGISTER_ZONE , paramsZona, new JsonHttpResponseHandler(){

                });
            }
        });

    }


    public void listhouse(View view){
        Intent list = new Intent(this,MainActivity.class);
        startActivity(list);
    }

}

