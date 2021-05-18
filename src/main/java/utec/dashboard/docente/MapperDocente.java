package utec.dashboard.docente;

import utec.dashboard.database.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperDocente {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    public ArrayList<Materia> getMateriasByDocente(int codigoDocente) {
        ArrayList<Materia> out = new ArrayList<Materia>();
        String sp = "GET_MATERIAS_BY_DOCENTE";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?)}");
            runStorageProcedure.setInt(1, codigoDocente);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                Materia materia = new Materia(datos.getString(1), datos.getString(2));
                materia.setSecciones(getSeccionesByDocente(codigoDocente, materia.getCodigo()));
                out.add(materia);

            }
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }

    private ArrayList<Seccion> getSeccionesByDocente(int codigoDocente, String codigoMateria) {
        ArrayList<Seccion> out = new ArrayList<Seccion>();
        String sp = "GET_SECCIONES_BY_DOCENTE";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?,?)}");
            runStorageProcedure.setInt(1, codigoDocente);
            runStorageProcedure.setString(2, codigoMateria);
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
