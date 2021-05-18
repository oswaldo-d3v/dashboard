package utec.dashboard.encargadoarea;

import utec.dashboard.docente.Materia;

import java.util.ArrayList;

public class Area {
    private String nombre;
    private ArrayList<Materia> materias = new ArrayList<Materia>();

    public Area(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }
}
