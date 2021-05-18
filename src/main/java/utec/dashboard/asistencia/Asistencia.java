package utec.dashboard.asistencia;

public class Asistencia {
    private String fecha;
    private int asistencia;
    private float porcentaje;
    private int duracion;

    public Asistencia(String fecha, int asistencia, float porcentaje, int duracion) {
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.porcentaje = porcentaje;
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
