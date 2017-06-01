package com.example.alumno.lavclase09;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 01/06/2017.
 */

public class XmlParser {

    public static List<Persona> obtenerPersonas(String xml){

        List<Persona> list = new ArrayList<>();
        XmlPullParser xmlPullParser = Xml.newPullParser();


        try {
            xmlPullParser.setInput(new StringReader(xml));

            int event = xmlPullParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){

                switch (event){

                    case XmlPullParser.START_DOCUMENT:

                        break;

                    case  XmlPullParser.START_TAG:
                         if (xmlPullParser.getName().equals("Persona"))
                         {
                             Persona p1 = new Persona();

                             p1.setNombre(xmlPullParser.getAttributeValue(null, "nombre"));
                             p1.setEdad(Integer.parseInt(xmlPullParser.getAttributeValue(null, "edad")));

                             list.add(p1);
                         }
                        break;

                    case  XmlPullParser.END_TAG:

                        break;

                }
                event = xmlPullParser.next();
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }



        return list;
    }
}
