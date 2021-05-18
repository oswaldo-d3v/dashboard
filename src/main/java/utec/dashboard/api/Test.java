package utec.dashboard.api;

import utec.dashboard.asistencia.Asistencia;
import utec.dashboard.asistencia.MapperAsistencia;
import utec.dashboard.asistencia.consultas.QueryFecha;
import utec.dashboard.utils.Utilidades;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        MapperAsistencia mapperAsistencia = new MapperAsistencia();
        QueryFecha objQuery = new QueryFecha("ADCC-I", 1, "2020-07-27", "2020-08-28");
        ArrayList<Asistencia> l = mapperAsistencia.getAsistenciaByFechas(objQuery);
        String out = Utilidades.json.toJson(l);
        System.out.println(out);
    }
}
