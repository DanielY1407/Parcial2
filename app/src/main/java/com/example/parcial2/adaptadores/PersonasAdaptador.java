package com.example.parcial2.adaptadores;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import clases.Personas;


public class PersonasAdaptador extends RecyclerView.Adapter<PersonasAdaptador.ViewHolder> {
    private List<Personas> datos;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(Personas persona);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public PersonasAdaptador(List<Personas> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personas dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre_persona, txt_especie_persona, txt_estado_persona;
        ImageView img_personas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre_persona = itemView.findViewById(R.id.txt_nombre_persona);
            txt_especie_persona = itemView.findViewById(R.id.txt_especie_persona);
            txt_estado_persona = itemView.findViewById(R.id.txt_estado_persona);
            img_personas = itemView.findViewById(R.id.img_personas);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(datos.get(position));
                        }
                    }
                }
            });
        }

        public void bind(Personas dato) {
            txt_nombre_persona.setText(dato.getNombre());
            txt_especie_persona.setText(dato.getEspecie());
            txt_estado_persona.setText(dato.getEstado());
            Picasso.get().load(dato.getImagen()).into(img_personas);
        }
    }
}
