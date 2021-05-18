package utec.dashboard.examinados.consultas;

public class QueryUnidad {
    private String codigoMateria;
    private int seccion;
    private int unidad;

    public QueryUnidad(String codigoMateria, int seccion, int unidad) {
        this.codigoMateria = codigoMateria;
        this.seccion = seccion;
        this.unidad = unidad;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }
}
