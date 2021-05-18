package utec.dashboard.encargadoarea;

import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

public class ServiciosArea {

    public String getArea(Request request, Response response) {
        Area area = (new MapperEncargadoArea()).getArea(request.params(":area"));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(area);
    }
}
