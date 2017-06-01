package com.example.alumno.lavclase09;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Handler
        Handler h = new Handler(this);


        //Hilo
        Thread miHilo = new Thread(new HiloConexion(h));

        miHilo.start();


    }

    @Override
    public boolean handleMessage(Message msg) {

        List<Persona> list = (List<Persona>) msg.obj;

        for (Persona p: list) {

            Toast.makeText(this, p.getNombre().toString() + " " + p.getEdad().toString(), Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
