package com.example.home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.home.utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RegisterUser extends AppCompatActivity {
    private Button register;
    private static Context RC=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        register=findViewById(R.id.btn_registerCl);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataUser();
                login(v);
            }
        });
    }
    private void  sendDataUser(){
        TextView firstName=findViewById(R.id.firstNameCl);
        TextView lastName=findViewById(R.id.lastNameCl);
        TextView ci=findViewById(R.id.ciCl);
        TextView email=findViewById(R.id.emailCl);
        TextView  sexo =findViewById(R.id.sexoCl);
        TextView address=findViewById(R.id.addressCl);
        TextView phone=findViewById(R.id.phoneCl);
        final TextView password=findViewById(R.id.passwordCl);
        TextView confPassword=findViewById(R.id.confPasswordCl);
        if(!password.getText().toString().equals(confPassword.getText().toString())){
            AlertDialog alertDialog =new AlertDialog.Builder(RegisterUser.this).create();
            alertDialog.setTitle("ERROR CONTRASEÑA");
            alertDialog.setMessage("las contraseñas no son identicas");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }
        else{
            AsyncHttpClient user=new AsyncHttpClient();
            RequestParams params=new RequestParams();
            params.add("address",address.getText().toString());
            params.add("apellidos",lastName.getText().toString());
            params.add("ci",ci.getText().toString());
            params.add("password",password.getText().toString());
            params.add("email",email.getText().toString());
            params.add("sexo",sexo.getText().toString());
            params.add("username", firstName.getText().toString());
            params.add("phone",phone.getText().toString());

            final String emailuser=password.getText().toString();
            final String passworduser=password.getText().toString();
            RC=getApplicationContext();
            user.post(Data.HOST+Data.REGISTER_USER,params,new JsonHttpResponseHandler(){

             @Override
             public void onSuccess(int statusCode, Header[]headers, JSONObject response){
                if(response.has("_id")){
                    AsyncHttpClient user=new AsyncHttpClient();
                    RequestParams params=new RequestParams();
                    params.add("email",emailuser);
                    params.add("password",passworduser);
                    user.post(Data.HOST+Data.LOGIN,params,new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                            try {
                                String token=response.getString("token");
                                Data.TOKEN="data"+token;
                                AlertDialog alertDialog = new AlertDialog.Builder(RegisterUser.this).create();
                                alertDialog.setTitle("SERVER RESPONSE");
                                alertDialog.setMessage("Registro Exitoso");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"DESEA REGISTRAR UN HOME", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent rhome=new Intent(RC, RegisterHome.class);
                                        startActivity(rhome);
                                        dialog.dismiss();
                                    }
                                });
                                alertDialog.show();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else{

                }
              }
            });
        }
    }
    public void login(View view){
        Intent login= new Intent(this, Login.class);
        startActivity(login);}

}
