package utec.dashboard.decano;

import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class ServiciosDecano {
    public String getFacultad(Request request, Response response) {
        Facultad facultad = (new MapperDecano()).getFacultad(request.params(":facultad"));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(facultad);
    }

    public String getFacultadesResponsable(Request request, Response response){
        ArrayList<String> facultades = (new MapperDecano()).getFacultadesResponsable(Integer.valueOf(request.params("idUsuario")));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(facultades);
    }
}
