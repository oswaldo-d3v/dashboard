package utec.dashboard.usuario;

import utec.dashboard.utils.PutObject;
import utec.dashboard.utils.Utilidades;
import spark.Request;
import spark.Response;

public class ServiciosUsuario {
    private MapperUsuario mp = new MapperUsuario();

    public String logearUsuario(Request req, Response res) {
        Usuario user = mp.logearUsuario(req.queryParams("user"), req.queryParams("pwd"));
        res.type("application/json");
        if (user == null) {
            res.status(401);
            return Utilidades.getMesageStatusError("Datos incorrectos");
        }
        res.status(200);
        return Utilidades.getMesageStatusOK(new PutObject<Usuario>(user));
    }
}
