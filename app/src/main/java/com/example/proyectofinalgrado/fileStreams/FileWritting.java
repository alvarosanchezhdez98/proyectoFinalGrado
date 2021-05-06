package com.example.proyectofinalgrado.fileStreams;

import android.icu.util.Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWritting {

    private final static String FILE_PATH="";
    //Default Option set
    private static String darkMode = "darkmode:-0";
    private static String showFullName = "showfullname:-0";
    private static String language = "language:-english";
    private static String notifications = "darkmode:-0";

    public static void setFileConfiguration(String option,String[] optionsChanges){
        //Initialized Buffers to null.
        FileOutputStream fos = null;
        OutputStreamWriter oos = null;
        int i=0;
        try{
            fos = new FileOutputStream(new File(FILE_PATH));
            oos = new OutputStreamWriter(fos);
            for (i = 0;i<optionsChanges.length ; i++) {

            }
            String fileConfig = darkMode + "\n" +
                    showFullName + "\n" +
                    language + "\n" +
                    notifications + "\n";

            oos.write(fileConfig);

        }catch(IOException io) {
        }

    }

}
