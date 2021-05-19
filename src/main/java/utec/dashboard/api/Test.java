package utec.dashboard.api;

import utec.dashboard.decano.MapperDecano;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        MapperDecano mapperDecano = new MapperDecano();
        ArrayList<String> l = mapperDecano.getFacultadesResponsable(2);
        for (String s : l) {
            System.out.println(s);
        }
    }
}
