package utec.dashboard.usuario;

import utec.dashboard.database.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MapperUsuario {
    Connection cn = Conexion.getConexion();;
    CallableStatement runStorageProcedure = null;

    public Usuario logearUsuario(String user, String pwd) {
        Usuario out = null;
        try {
            runStorageProcedure = cn.prepareCall("{CALL LOGEAR_USUARIO(?, ?)}");
            runStorageProcedure.setString(1, user);
            runStorageProcedure.setString(2, pwd);
            ResultSet datos = runStorageProcedure.executeQuery();
            if (datos.next()) {
                out = new Usuario(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getInt(6)
                );
                datos.close();
                out.setPrivilegios(getPrivilegiosUsuario(out.getId()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el CONSULTAR_PRIVILEGIOS.");
        }
        return out;
    }

    public ArrayList<String> getPrivilegiosUsuario(int id) {
        ArrayList<String> out = new ArrayList<String>();
        try {
            runStorageProcedure = cn.prepareCall("{CALL GET_PRIVILEGIOS(?)}");
            runStorageProcedure.setInt(1, id);
            ResultSet datos = runStorageProcedure.executeQuery();
            while (datos.next()) {
                out.add(datos.getString(2));
            }
            datos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el GET_PRIVILEGIOS.");
        }
        return out;
    }
}
