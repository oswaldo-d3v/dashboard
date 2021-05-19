package utec.dashboard.encargadoarea;

import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class ServiciosArea {

    public String getArea(Request request, Response response) {
        Area area = (new MapperEncargadoArea()).getArea(request.params(":area"));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(area);
    }

    public String getAreasResponsable(Request request, Response response){
        ArrayList<String> areas = (new MapperEncargadoArea()).getAresResponsable(Integer.valueOf(request.params(":idUsuario")));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(areas);
    }
}
