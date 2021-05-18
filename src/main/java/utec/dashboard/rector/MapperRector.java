package utec.dashboard.rector;

import utec.dashboard.database.Conexion;
import utec.dashboard.docente.Seccion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperRector {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    private ArrayList<String> getAll(String sp) {
        ArrayList<String> out = new ArrayList<String>();
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "()}");
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

    public ArrayList<String> getAllFacultades() {
        return getAll("GET_FACULTADES");
    }

    public ArrayList<String> getAllEscuelas() {
        return getAll("GET_ESCUELAS");
    }

    public ArrayList<String> getAllAreas() {
        return getAll("GET_AREAS");
    }

    public ArrayList<String> getMaterias(){
        return getAll("GET_MATERIAS");
    }

    public ArrayList<Seccion> getSecciones(String codigoMateria) {
        ArrayList<Seccion> out = new ArrayList<Seccion>();
        String sp = "GET_SECCIONES";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?)}");
            runStorageProcedure.setString(1, codigoMateria);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                out.add(new Seccion(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getInt(4)
                ));
            }
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }

}
