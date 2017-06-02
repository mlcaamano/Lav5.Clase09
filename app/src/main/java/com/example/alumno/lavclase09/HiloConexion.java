package com.example.alumno.lavclase09;

import android.os.Handler;
import android.os.Message;

/**
 * Created by matias on 20/05/2017.
 */

public class HiloConexion implements Runnable {

    private Handler h;
    private Message miMensaje;
    private Conexion miConexion;


    public HiloConexion(Handler h){
        this.h=h;
    }

    @Override
    public void run() {
        miConexion= Conexion.getConexionInternet();
        miMensaje = new Message();

        try{

            //String s = new String(miConexion.getXmlByGet("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml")); //Para traer un xml
            String s = new String(miConexion.getXmlByGet("http://192.168.2.103:3000/usuarios/"));
            //miMensaje.obj = XmlParser.obtenerPersonas(s); // para traer lista de persona por xml

            miMensaje.obj = JasonPar.parcers(s);


            h.sendMessage(miMensaje);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }

}
