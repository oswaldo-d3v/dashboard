package utec.dashboard.examinados;

import utec.dashboard.asistencia.Asistencia;
import utec.dashboard.database.Conexion;
import utec.dashboard.examinados.consultas.QueryUnidad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperExaminados {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    public ArrayList<Examinados> getExaminadosByUnidad(QueryUnidad queryUnidad){
        ArrayList<Examinados> out = new ArrayList<Examinados>();
        String sp = "GET_EXAMINADOS_BY_UNIDAD";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?, ?, ?)}");
            runStorageProcedure.setString(1, queryUnidad.getCodigoMateria());
            runStorageProcedure.setInt(2, queryUnidad.getSeccion());
            runStorageProcedure.setInt(3, queryUnidad.getUnidad());
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                Examinados examinados = new Examinados(
                        datos.getInt(1),
                        datos.getFloat(2),
                        datos.getString(3)
                );
                out.add(examinados);
            }
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }
}
