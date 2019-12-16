package com.example.home;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.home.utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
     //import com.example.home.utils.Data;

import org.json.JSONObject;

//import cz.msebera.android.httpclient.Header;

public class Login extends AppCompatActivity {
    private Button login;
    private Button registerNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener(){
           @Override
           public  void onClick(View v){
               loginUser();
               princi(v);
           }
        });
    }
    public void loginUser(){
        TextView email=findViewById(R.id.emailCl);
        TextView password=findViewById(R.id.passwordCl);
        AsyncHttpClient user=new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.add("email",email.getText().toString());
        params.add("password",password.getText().toString());
        user.post(Data.HOST+Data.LOGIN,params,new JsonHttpResponseHandler(){

        public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject response){
            AlertDialog alertDialog =new AlertDialog.Builder(Login.this).create();
            try {
                String token=response.getString("token");
                alertDialog.setTitle("RESPONSE SERVE");
                alertDialog.setMessage("Sesion Iniciada");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
                Data.TOKEN="data"+token;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

     });
    }
    public void princi(View view){
        Intent main= new Intent(this, roles.class);
        startActivity(main);}
    public void Registrar(View view){
        Intent login= new Intent(this, RegisterUser.class);
        startActivity(login);}

}
