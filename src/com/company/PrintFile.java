package com.company;

import java.io.*;


public class PrintFile {

    private String filename;
    private File file;

    public PrintFile(String filename) throws FileNotFoundException
    {
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




    public void replaceWith(String currentValue, String newValue)
    {

        try
        {

            BufferedReader br = new BufferedReader(new FileReader("Eliteswimmers.txt"));

            String lines = ""; //holds the lines of file.

            //loop through all lines.
            for (String line = br.readLine(); line != null; line = br.readLine())
            {
                line = line.replace(currentValue, newValue); //replaces old value, with the new. (If the string exist).
                lines += line;
            }

            //clear the whole txt file
            PrintWriter writer = new PrintWriter("Eliteswimmers.txt");
            writer.print("");
            writer.close();

            //update the .txt file.
            writeToFile(lines);
            System.out.println(lines);

        } catch(IOException Exception)
        {
            System.out.println("Something went wrong, when we tried to replace.");
        }

    }

}