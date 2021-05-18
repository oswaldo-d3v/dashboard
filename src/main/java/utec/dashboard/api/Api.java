package utec.dashboard.api;

import static spark.Spark.*;

public class Api {


    public static void main(String[] args) {
        Api miAPI = new Api();
        miAPI.setConfig();

        EndPoints misEndPoints = new EndPoints();

        misEndPoints.servciosUsuario();
        misEndPoints.serviciosDocente();
        misEndPoints.serviciosEncargadoArea();
        misEndPoints.serviciosDirector();
        misEndPoints.serviciosDecano();
        misEndPoints.serviciosRector();
        misEndPoints.serviciosAsistencia();
        misEndPoints.serviciosExaminados();

    }

    private void setConfig() {
        Configuracion config = new Configuracion();
        port(config.getPuerto());
        config.soporteCORS("*", "POST", "Access-Control-Allow-Origin, contentType");
    }
}
