package utec.dashboard.decano;

import utec.dashboard.director.Escuela;

import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private ArrayList<Escuela> escuelas = new ArrayList<Escuela>();

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.escuelas = escuelas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Escuela> getEscuelas() {
        return escuelas;
    }

    public void setEscuelas(ArrayList<Escuela> escuelas) {
        this.escuelas = escuelas;
    }
}
