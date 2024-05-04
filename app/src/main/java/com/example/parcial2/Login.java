package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    Button btn;
    EditText usuario, contraseña;
    String dato;
    android.content.SharedPreferences SharedPreferences;
    android.content.SharedPreferences.Editor editor;
    public static final String dataUser = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        btn = findViewById(R.id.btn);
        usuario = findViewById(R.id.botonusuario);
        contraseña = findViewById(R.id.botoncontraseña);

        SharedPreferences = getSharedPreferences(dataUser, modo_private);
        editor = SharedPreferences.edit();
        dato = getApplicationContext().getSharedPreferences(dataUser, modo_private).getString("user", " ");

        if (!dato.equalsIgnoreCase(" ")) {
            Intent i = new Intent(Login.this, ActivityInicio.class);
            startActivity(i);
            finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = usuario.getText().toString();
                String v2 = contraseña.getText().toString();
                editor.putString("user", usuario.getText().toString());
                editor.commit();

                if (v1.equals("") && v2.equals("")) {
                    Toast.makeText(Login.this, "Tiene que llenar los campos", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Login.this, ActivityInicio.class);
                    startActivity(intent);
                    Toast.makeText(Login.this, "Ingresando", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}