package utec.dashboard.director;

import utec.dashboard.database.Conexion;
import utec.dashboard.encargadoarea.Area;
import utec.dashboard.encargadoarea.MapperEncargadoArea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperDirector {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    public Escuela getEscuela(String escuela){
        Escuela out = new Escuela(escuela);
        MapperEncargadoArea mapperEncargadoArea = new MapperEncargadoArea();
        ArrayList<Area> areas = new ArrayList<Area>();
        String sp = "GET_AREAS_BY_ESCUELA";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?)}");
            runStorageProcedure.setString(1, escuela);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                areas.add(mapperEncargadoArea.getArea(datos.getString(1)));
            }
            datos.close();
            out.setAreas(areas);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }

    public ArrayList<String> getEscuelasResponsable(int id) {
        ArrayList<String> out = new ArrayList<String>();
        String sp = "GET_ESCUELAS_ACARGO";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?)}");
            runStorageProcedure.setInt(1, id);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                out.add(datos.getString(1));
            }
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }
}
