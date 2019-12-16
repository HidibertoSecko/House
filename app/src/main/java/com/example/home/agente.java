package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class agente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agente);
    }

    public void house(View v)
    {
        Intent house = new Intent(this, RegisterHome.class);
        startActivity(house);
    }

    public void listar_house(View v)
    {
        Intent house = new Intent(this, MainActivity.class);
        startActivity(house);
    }
    public void registrar_zona(View v)
    {
        Intent registrar_zona = new Intent(this, Registrar_zonas.class);
        startActivity(registrar_zona);
    }
}
