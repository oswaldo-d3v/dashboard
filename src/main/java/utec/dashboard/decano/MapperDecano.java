package utec.dashboard.decano;

import utec.dashboard.database.Conexion;
import utec.dashboard.director.Escuela;
import utec.dashboard.director.MapperDirector;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperDecano {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    public Facultad getFacultad(String facultad){
        Facultad out = new Facultad(facultad);
        ArrayList<Escuela> escuelas = new ArrayList<Escuela>();
        MapperDirector mapperDirector = new MapperDirector();
        String sp = "GET_FACULTAD";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?)}");
            runStorageProcedure.setString(1, facultad);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                Escuela escuela = mapperDirector.getEscuela(datos.getString(1));
                escuelas.add(escuela);
            }
            out.setEscuelas(escuelas);
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }
}
