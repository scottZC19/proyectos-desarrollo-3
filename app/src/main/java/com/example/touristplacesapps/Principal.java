package com.example.touristplacesapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity {

    Button LTCusco, MMAntiguas, MMModernas, PuntoRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        LTCusco = (Button)findViewById(R.id.btnLugaresCusco);
        MMAntiguas = (Button)findViewById(R.id.btnMavAntiguas);
        MMModernas = (Button)findViewById(R.id.btnMavModernas);
        PuntoRuta = (Button)findViewById(R.id.btnRuta);

        LTCusco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LugaresCusco.class);
                startActivity(intent);
            }
        });

        MMAntiguas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MaravillasAnt.class);
                startActivity(intent);
            }
        });

        MMModernas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MaravillasModer.class);
                startActivity(intent);
            }
        });

        PuntoRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Rutas.class);
                startActivity(intent);
            }
        });
    }
}