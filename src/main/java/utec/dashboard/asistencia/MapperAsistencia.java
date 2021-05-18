package utec.dashboard.asistencia;

import utec.dashboard.asistencia.consultas.QueryFecha;
import utec.dashboard.database.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperAsistencia {
    Connection cn = Conexion.getConexion();
    CallableStatement runStorageProcedure = null;

    public ArrayList<Asistencia> getAsistenciaByFechas(QueryFecha query) {
        ArrayList<Asistencia> out = new ArrayList<Asistencia>();
        String sp = "GET_ASISTENCIA_BY_FECHAS";
        try {
            runStorageProcedure = cn.prepareCall("{CALL " + sp + "(?, ?, ?, ?)}");
            runStorageProcedure.setString(1, query.getCodigoMateria());
            runStorageProcedure.setInt(2, query.getSeccion());
            runStorageProcedure.setString(3, query.getFechaLimiteInferior());
            runStorageProcedure.setString(4, query.getFechaLimiteSuperior());
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                Asistencia asistencia = new Asistencia(
                        datos.getString(1),
                        datos.getInt(2),
                        datos.getFloat(3),
                        datos.getInt(4)
                );
                out.add(asistencia);
            }
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el " + sp + ".");
        }
        return out;
    }
}
