package com.example.proyectofinalgrado.fileStreams;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritting {

    private static File choosedFile;

    /**
     * Method for write a file.
     * @param destinationFolder : Folder where we want to save File.
     * @param fileName : Name of file.
     * @param data : Data that is going to be on the file.
     */
    public static void writeFile(String destinationFolder,String fileName,String data){
        //Initialized Buffers to null.
        FileWriter fw = null;
        PrintWriter pw = null;
        try{
            String filePath = (Environment.getExternalStorageDirectory() + destinationFolder);
            File fileDirectory = new File(filePath);
            //Check if directory exists
            if(!fileDirectory.exists()){
                fileDirectory.mkdir();
            }
            choosedFile = new File(fileDirectory,fileName);
            choosedFile.createNewFile();

            fw = new FileWriter(choosedFile);
            pw = new PrintWriter(fw);

            pw.println(data);

            //Clearing Output Buffers
            pw.flush();
            pw.close();
            fw.close();
        }catch(IOException io) {

        }
    }


}
