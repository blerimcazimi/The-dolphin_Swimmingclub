package com.company;

import java.io.*;


public class FileClass {

    private String filename;
    protected String workingDir = "/Users/Thomas/Desktop/DolphinClub/";
    private File file;


    public FileClass(String filename) throws FileNotFoundException {
        this.filename = filename;
        file = new File(workingDir.concat(filename.concat(".txt")));
    }

    public void writeToFile(String s) throws IOException {

        if(!file.exists())
            file.createNewFile();

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(s);
        bufferedWriter.close();
    }

}