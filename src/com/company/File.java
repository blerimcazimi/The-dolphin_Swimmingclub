package com.company;

import java.io.*;


public class File {

    private String filename;
    private java.io.File file;

    public File(String filename) throws FileNotFoundException
    {
        System.out.println("lol");
        this.filename = filename;
        file = new java.io.File(filename.concat(".txt"));
    }

    public void writeToFile(String s) throws IOException
    {

        if(!file.exists())
        {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(s);
        bufferedWriter.close();
    }

}