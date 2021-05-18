package utec.dashboard.docente;

public class Seccion {
    private int seccion;
    private String dias;
    private String horario;
    private int inscritos;

    public Seccion(int seccion, String dias, String horario, int inscritos) {
        this.seccion = seccion;
        this.dias = dias;
        this.horario = horario;
        this.inscritos = inscritos;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }
}
