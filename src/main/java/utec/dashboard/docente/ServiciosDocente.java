package utec.dashboard.docente;

import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class ServiciosDocente {
    MapperDocente mapperDocente = new MapperDocente();

    public String getMateriasByCodigoEmpleado(Request request, Response response){
        ArrayList<Materia> materias = mapperDocente.getMateriasByDocente(Integer.valueOf(request.params(":codigo")));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(materias);
    }
}
