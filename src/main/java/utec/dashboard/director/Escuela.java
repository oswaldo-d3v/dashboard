package utec.dashboard.director;

import utec.dashboard.encargadoarea.Area;

import java.util.ArrayList;

public class Escuela {
    private String nombre;
    private ArrayList<Area> areas = new ArrayList<Area>();

    public Escuela(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }
}
