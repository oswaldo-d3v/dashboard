package utec.dashboard.utils;

import com.google.gson.Gson;

public class Utilidades {
    public static Gson json = new Gson();

    public static String getMesageStatusOK( PutObject obj){
        return json.toJson(obj.getObj());
    }

    public static String getMesageStatusError(String msgError){
        return json.toJson((new MensajeStatus(msgError)));
    }
}
