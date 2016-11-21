package com.company;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.ArrayList;

public class File {

    private String filename;

    private PrintStream out;



    public File(String filename) throws FileNotFoundException {
        this.filename = filename;
        out = new PrintStream(this.filename);
    }

    public void writeToFile(String s){

        out.println(s);

    }

}