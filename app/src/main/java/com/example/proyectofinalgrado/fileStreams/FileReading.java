package com.example.proyectofinalgrado.fileStreams;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReading {

    private final static String FILE_PATH="";


    public static void setFileConfiguration(){
        //Initialized Buffers to null.
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            fis = new FileInputStream(new File(FILE_PATH));
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = "";
            ArrayList<String> fileLines = new ArrayList<String>();
            while((line = br.readLine())!=null){
                fileLines.add(line);
            }

            //Llamar a la clase que aplica la configuracion con bucle for sobre la lista.
            for (String config: fileLines) {

            }

            br.close();
            isr.close();
            fis.close();
        }catch(IOException io){

        }
    }

}
