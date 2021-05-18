package utec.dashboard.asistencia.consultas;

public class QueryFecha {
    private String codigoMateria;
    private int seccion;
    private String fechaLimiteInferior;
    private String fechaLimiteSuperior;

    public QueryFecha(String codigoMateria, int seccion, String fechaLimiteInferior, String fechaLimiteSuperior) {
        this.codigoMateria = codigoMateria;
        this.seccion = seccion;
        this.fechaLimiteInferior = fechaLimiteInferior;
        this.fechaLimiteSuperior = fechaLimiteSuperior;
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

    public String getFechaLimiteInferior() {
        return fechaLimiteInferior;
    }

    public void setFechaLimiteInferior(String fechaLimiteInferior) {
        this.fechaLimiteInferior = fechaLimiteInferior;
    }

    public String getFechaLimiteSuperior() {
        return fechaLimiteSuperior;
    }

    public void setFechaLimiteSuperior(String fechaLimiteSuperior) {
        this.fechaLimiteSuperior = fechaLimiteSuperior;
    }
}
