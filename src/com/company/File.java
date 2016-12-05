package com.company;

import java.io.*;

public class File {

    private String filename;
    private java.io.File file;

    public File(String filename) throws FileNotFoundException
    {
        this.filename = filename;
        file = new java.io.File(filename.concat(".txt"));
    }

    /**
        This method allows us to replace a value with a new value in a .txt file.
        @param String CurrentValue, String newValue, String lineMustContain
     */
    public void replaceWith(String currentValue, String newValue, String lineMustContain)
    {

        try
        {

            BufferedReader br = new BufferedReader(new FileReader("MembersInfo.txt"));

            String lines = ""; //holds the lines of file.

            //loop through all lines in the txt file.
            String line;
            while ((line = br.readLine()) != null)
            {
                if(line.contains(lineMustContain))
                {
                    line = line.replace(currentValue, newValue); //replaces old value, with the new. (If the string exist).
                }
                    lines += line + System.lineSeparator();
            }

            //clear the whole txt file
            PrintWriter writer = new PrintWriter("MembersInfo.txt");
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

    public void writeToFile(String s) throws IOException
    {

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(s);
        bufferedWriter.close();

    }

}