package clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Personas implements Parcelable {

    private String imagen;
    private String nombre;
    private String estado;

    private String especie;

    public Personas(String imagen, String nombre, String estado, String especie) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = estado;
        this.especie = especie;
    }


    protected Personas(Parcel in) {
        imagen = in.readString();
        nombre = in.readString();
        estado = in.readString();
        especie = in.readString();
    }

    public static final Parcelable.Creator<Personas> CREATOR = new Parcelable.Creator<Personas>() {
        @Override
        public  Personas createFromParcel(Parcel in) {
            return new Personas(in);
        }

        @Override
        public Personas[] newArray(int size) {
            return new Personas[size];
        }
    };

    public String getImagen() {
        return imagen;
    }


    public String getNombre() {
        return nombre;
    }


    public String getEstado() {
        return estado;
    }


    public String getEspecie() {
        return especie;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagen);
        dest.writeString(nombre);
        dest.writeString(estado);
        dest.writeString(especie);
    }

}
