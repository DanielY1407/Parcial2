package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.adaptadores.PersonasAdaptador;

import clases.Personas;

import java.util.ArrayList;
import java.util.List;

public class ActivityInicio extends AppCompatActivity {


    RecyclerView rcv_personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        rcv_personas = findViewById(R.id.rcv_personas);


        List<Personas> ListaPersonas= new ArrayList<>();
        ListaPersonas.add(new Personas("https://rickandmortyapi.com/api/character/avatar/72.jpeg", "Rick Sanchez", "Alive", "Humano"));
        ListaPersonas.add(new Personas("https://comicvine.gamespot.com/a/uploads/scale_medium/6/66303/4469088-tumblr_inline_n0aleph3fl1r8rr6o.jpg", "Morthy Smith", "Alive", "Humano"));
        ListaPersonas.add(new Personas("https://rickandmortyapi.com/api/character/avatar/120.jpeg", "Summer Smith", "Alive", "Humano"));
        ListaPersonas.add(new Personas("https://static.wikia.nocookie.net/rick-y-morty-espanol/images/c/c0/Beth_smith.jpg/revision/latest?cb=20230301203350&path-prefix=es", "Beth Smith", "Alive", "Humano"));
        ListaPersonas.add(new Personas("https://pbs.twimg.com/profile_images/887502042104647680/rJLArq2q_400x400.jpg", "Jerry Smith", "Alive", "Humano"));

        rcv_personas.setLayoutManager(new LinearLayoutManager(this));
        PersonasAdaptador adaptador = new PersonasAdaptador(ListaPersonas);
        rcv_personas.setAdapter(adaptador);


        adaptador.setOnItemClickListener(new PersonasAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Personas personas) {
                Intent intent = new Intent(ActivityInicio.this, Listener.class);
                intent.putExtra("persona", personas);
                startActivity(intent);
            }
        });
    }
}