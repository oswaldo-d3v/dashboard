package utec.dashboard.examinados;

import spark.Request;
import spark.Response;
import utec.dashboard.examinados.consultas.QueryUnidad;
import utec.dashboard.utils.Utilidades;

import java.util.ArrayList;

public class ServiciosExaminados {
    MapperExaminados mapperExaminados = new MapperExaminados();

    public String getExaminadosByUnidad(Request request, Response response, QueryUnidad queryUnidad){
        ArrayList<Examinados> examinados = mapperExaminados.getExaminadosByUnidad(queryUnidad);
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(examinados);
    }
}
