package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class roles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);
    }

    public void roluser(View view)
    {
        Intent user = new Intent(this, MainActivity.class);
        startActivity(user);
    }

    public void rolagente(View view)
    {
        Intent agente = new Intent(this,agente.class );
        startActivity(agente);
    }
}
