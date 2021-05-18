package utec.dashboard.encargadoarea;

import utec.dashboard.database.Conexion;
import utec.dashboard.docente.Materia;
import utec.dashboard.rector.MapperRector;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperEncargadoArea {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    public Area getArea(String area){
        MapperRector mapperRector = new MapperRector();
        ArrayList<Materia> materias = new ArrayList<Materia>();
        Area out = new Area(area);
        String sp = "GET_MATERIAS_BY_AREA";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?)}");
            runStorageProcedure.setString(1, area);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                Materia materia = new Materia(datos.getString(1), datos.getString(2));
                materia.setSecciones(mapperRector.getSecciones(materia.getCodigo()));
                materias.add(materia);
            }
            datos.close();
            out.setMaterias(materias);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }
}
