package com.example.proyectofinalgrado.fileStreams;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReading {

    private static File choosedFile;

    public static void setFileConfiguration(String destinationFolder,String fileName,String data){
        //Initialized Buffers to null.
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            String filePath = (Environment.getExternalStorageDirectory() + destinationFolder);
            File fileDirectory = new File(filePath);
            //Check if directory exists
            if(!fileDirectory.exists()){
                fileDirectory.mkdir();
            }
            choosedFile = new File(fileDirectory,fileName);

            fis = new FileInputStream(choosedFile);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            String fileLine ="";
            while((fileLine=br.readLine())!=null){

            }
            br.close();
            isr.close();
            fis.close();
        }catch(IOException io){

        }
    }

}
