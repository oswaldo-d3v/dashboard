package utec.dashboard.api;

import utec.dashboard.asistencia.ServiciosAsistencia;
import utec.dashboard.asistencia.consultas.QueryFecha;
import utec.dashboard.decano.ServiciosDecano;
import utec.dashboard.director.ServiciosDirector;
import utec.dashboard.docente.ServiciosDocente;
import utec.dashboard.encargadoarea.ServiciosArea;
import utec.dashboard.examinados.ServiciosExaminados;
import utec.dashboard.examinados.consultas.QueryUnidad;
import utec.dashboard.rector.ServiciosRector;
import utec.dashboard.usuario.ServiciosUsuario;
import utec.dashboard.utils.Utilidades;

import static spark.Spark.get;
import static spark.Spark.post;

public class EndPoints {
    public void servciosUsuario() {
        ServiciosUsuario serviciosUsuario = new ServiciosUsuario();

        post("/login", (request, response) -> {
            return serviciosUsuario.logearUsuario(request, response);
        });
    }

    public void serviciosDocente() {
        ServiciosDocente serviciosDocente = new ServiciosDocente();

        get("/docente/materias/:codigo", (request, response) -> {
            return serviciosDocente.getMateriasByCodigoEmpleado(request, response);
        });
    }

    public void serviciosEncargadoArea() {
        ServiciosArea serviciosArea = new ServiciosArea();

        get("/encargadoarea/:area", (request, response) -> {
            return serviciosArea.getArea(request, response);
        });
    }

    public void serviciosDirector() {
        ServiciosDirector serviciosDirector = new ServiciosDirector();

        get("/director/:escuela", (request, response) -> {
            return serviciosDirector.getEscuela(request, response);
        });
    }

    public void serviciosDecano() {
        ServiciosDecano serviciosDecano = new ServiciosDecano();

        get("/decano/:facultad", (request, response) -> {
            return serviciosDecano.getFacultad(request, response);
        });
    }

    public void serviciosRector() {
        ServiciosRector serviciosRector = new ServiciosRector();

        get("/getFacultades", (request, response) -> {
            return serviciosRector.getAllFacultades(request, response);
        });

        get("/getEscuelas", (request, response) -> {
            return serviciosRector.getAllEscuelas(request, response);
        });

        get("/getAreas", (request, response) -> {
            return serviciosRector.getAllAreas(request, response);
        });

        get("/getMaterias", (request, response) -> {
            return serviciosRector.getAllMaterias(request, response);
        });

        get("/getSeccion/:codigoMateria", (request, response) -> {
            return serviciosRector.getSecciones(request, response);
        });
    }

    public void serviciosAsistencia() {
        ServiciosAsistencia serviciosAsistencia = new ServiciosAsistencia();

        post("/asistencia/fecha", (request, response) -> {
            QueryFecha queryFecha = Utilidades.json.fromJson(request.body(), QueryFecha.class);
            return serviciosAsistencia.getAsistenciaByFecha(request, response, queryFecha);
        });
    }

    public void serviciosExaminados() {
        ServiciosExaminados serviciosExaminados = new ServiciosExaminados();

        post("/examinados/unidad", (request, response) -> {
            QueryUnidad queryUnidad = Utilidades.json.fromJson(request.body(), QueryUnidad.class);
            return serviciosExaminados.getExaminadosByUnidad(request, response, queryUnidad);
        });
    }
}
