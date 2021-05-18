package utec.dashboard.rector;

import utec.dashboard.docente.Seccion;
import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class ServiciosRector {
    public String getAllFacultades(Request request, Response response){
        ArrayList<String> facultades = (new MapperRector()).getAllFacultades();
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(facultades);
    }

    public String getAllEscuelas(Request request, Response response){
        ArrayList<String> escuelas = (new MapperRector()).getAllEscuelas();
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(escuelas);
    }

    public String getAllAreas(Request request, Response response){
        ArrayList<String> areas = (new MapperRector()).getAllAreas();
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(areas);
    }

    public String getAllMaterias(Request request, Response response){
        ArrayList<String> materias = (new MapperRector()).getMaterias();
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(materias);
    }

    public String getSecciones(Request request, Response response){
        ArrayList<Seccion> seccions = (new MapperRector()).getSecciones(request.params(":codigoMateria"));
        response.type("application/json");
        response.status(200);
        return Utilidades.json.toJson(seccions);
    }

}
