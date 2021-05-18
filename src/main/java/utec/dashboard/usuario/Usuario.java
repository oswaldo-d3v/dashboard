package utec.dashboard.usuario;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private int codigoEmpleado;
    private String nombre;
    private String fotografia;
    private String usuario;
    private int estado;
    private ArrayList<String> privilegios = new ArrayList<String>();

    public Usuario(int id, int codigoEmpleado, String nombre, String fotografia, String usuario, int estado) {
        this.id = id;
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.fotografia = fotografia;
        this.usuario = usuario;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ArrayList<String> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(ArrayList<String> privilegios) {
        this.privilegios = privilegios;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
