package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;


import clases.Personas;

public class Listener extends AppCompatActivity {
    private TextView tv_nombre_persona, tv_estado, tv_especie;
    private ImageView imgPersona;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);

        imgPersona = findViewById(R.id.tv_img_persona);
        tv_nombre_persona = findViewById(R.id.tv_nombre_persona);
        tv_estado = findViewById(R.id.tv_estado);
        tv_especie = findViewById(R.id.tv_especie);
        btnCerrarSesion = findViewById(R.id.boton_cerrar_sesion);

        Personas persona = getIntent().getParcelableExtra("usuario");

        if (persona != null) {
            Picasso.get().load(persona.getImagen()).into(imgPersona);
            tv_nombre_persona.setText(persona.getNombre());
            tv_estado.setText("Vivo: " + persona.getEstado());
            tv_especie.setText("Especie: " + persona.getEspecie());
        }
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences(Login.dataUser, MODE_PRIVATE).edit().clear().apply();
                Intent intent = new Intent(Listener.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
