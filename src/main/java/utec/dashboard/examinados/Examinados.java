package utec.dashboard.examinados;

public class Examinados {
    private int examinados;
    private float porcentaje;
    private String tipo;

    public Examinados(int examinados, float porcentaje, String tipo) {
        this.examinados = examinados;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
    }

    public int getExaminados() {
        return examinados;
    }

    public void setExaminados(int examinados) {
        this.examinados = examinados;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
