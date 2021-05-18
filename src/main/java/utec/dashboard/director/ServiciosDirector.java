package utec.dashboard.director;

import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

public class ServiciosDirector {
    public String getEscuela(Request request, Response response) {
        Escuela escuela = (new MapperDirector()).getEscuela(request.params(":escuela"));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(escuela);
    }
}
