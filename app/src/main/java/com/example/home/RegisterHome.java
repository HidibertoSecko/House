package com.example.home;

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

public class RegisterHome extends AppCompatActivity {
    private Button register_house;
    private static Context Reg_house=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_home);


        register_house=findViewById(R.id.registrar_casa);
        register_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senRegisterHouse();
                listhouse(v);
            }

            private void senRegisterHouse() {
                TextView ciudad = findViewById(R.id.rciudad);
                TextView region =findViewById(R.id.rregion);
                TextView zona =findViewById(R.id.rzona);
                TextView precio =findViewById(R.id.rprecio);
                TextView descripcion =findViewById(R.id.rdescripcion);
                TextView baños =findViewById(R.id.rbaño);
                TextView habitacion =findViewById(R.id.rcuartos);
                TextView living_area=findViewById(R.id.rliving);
                TextView lot_area=findViewById(R.id.rlot_area);
                TextView piscina =findViewById(R.id.rpiscina);
                TextView foto =findViewById(R.id.rphoto);
                TextView servicios =findViewById(R.id.rservicio);
                TextView garaje =findViewById(R.id.rgaraje);
                TextView latitud =findViewById(R.id.rlatitud);
                TextView longitud =findViewById(R.id.rlongitud);
                TextView año_construccion =findViewById(R.id.rañoconstruccion);

                AsyncHttpClient house = new AsyncHttpClient();
                RequestParams paramsHouse = new RequestParams();
                paramsHouse.add("city",ciudad.getText().toString());
                paramsHouse.add("region",region.getText().toString());
                paramsHouse.add("zone",zona.getText().toString());
                paramsHouse.add("precio",precio.getText().toString());
                paramsHouse.add("property_descryption",descripcion.getText().toString());
                paramsHouse.add("bedrooms",baños.getText().toString());
                paramsHouse.add("badrooms",habitacion.getText().toString());
                paramsHouse.add("living_area",living_area.getText().toString());
                paramsHouse.add("lot_area",lot_area.getText().toString());
                paramsHouse.add("piscina",piscina.getText().toString());
                paramsHouse.add("photo",foto.getText().toString());
                paramsHouse.add("servicios",servicios.getText().toString());
                paramsHouse.add("garaje",garaje.getText().toString());
                paramsHouse.add("latitud",latitud.getText().toString());
                paramsHouse.add("longitud",longitud.getText().toString());
                paramsHouse.add("año_construccion",año_construccion.getText().toString());
                house.post(Data.HOST + Data.REGISTER_HOME , paramsHouse, new JsonHttpResponseHandler(){

                });
            }
        });

    }


    public void listhouse(View view){
        Intent list = new Intent(this,MainActivity.class);
        startActivity(list);
    }

}
