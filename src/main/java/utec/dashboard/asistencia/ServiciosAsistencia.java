package utec.dashboard.asistencia;

import spark.Request;
import spark.Response;
import utec.dashboard.asistencia.consultas.QueryFecha;
import utec.dashboard.utils.Utilidades;

import java.util.ArrayList;

public class ServiciosAsistencia {
    MapperAsistencia mapperAsistencia = new MapperAsistencia();

    public String getAsistenciaByFecha(Request request, Response response, QueryFecha queryFecha){
        ArrayList<Asistencia> asistencias = mapperAsistencia.getAsistenciaByFechas(queryFecha);
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(asistencias);

    }

}
