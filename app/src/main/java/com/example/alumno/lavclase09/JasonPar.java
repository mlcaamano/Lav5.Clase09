package com.example.alumno.lavclase09;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 01/06/2017.
 */

public class JasonPar {


    public static List<Persona> parcers (String s){
        List<Persona> list = new ArrayList<>();


        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray usuarios = jsonObject.getJSONArray("usuarios");

            for ( int i =0; i< usuarios.length() ;i++ ){
                JSONObject aux = usuarios.getJSONObject(i);
                Persona p1 = new Persona();
                p1.setNombre(aux.getString("nombre"));
                p1.setEdad(aux.getInt("dni"));
                list.add(p1);
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
