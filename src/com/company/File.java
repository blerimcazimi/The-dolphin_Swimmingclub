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
     * This method allows us to read a .txt file using BufferReader.
     * @return BufferReader br
     */
    public BufferedReader readFile()
    {

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            return br;

        } catch (IOException error)
        {
            System.out.println("Kunne ikke læse filen..");
            return null;
        }

    }

    /**
     * Instead of returning lines form a file. This method will just system.out them.
     */
    public void systemOutFile() throws IOException
    {
        String line;
        BufferedReader br = readFile();
        while ((line = br.readLine()) != null)
        {

            System.out.println(line);

        }

    }

    /**
     * This method finds a line where the keywordToFind is contained.
     * @param keywordToFind
     * @return String keyword
     */
    public String specificKeyword(String keywordToFind) throws IOException
    {

        String line;
        BufferedReader br = readFile();
        while ((line = br.readLine()) != null)
        {
            if(line.contains(keywordToFind))
            {
                return line;
            }
        }

        return "";

    }


    /**
        This method allows us to replace a value with a new value in a .txt file.
        @param String CurrentValue, String newValue, String lineMustContain
     */
    public void replaceWith(String currentValue, String newValue, String lineMustContain)
    {

        try
        {

            BufferedReader br = new BufferedReader(new FileReader(file));

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
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            //update the .txt file.
            writeToFile(lines);
            System.out.println(lines);

        } catch(IOException Exception)
        {
            System.out.println("Metoden fejlede" + Exception);
        }

    }

    public void writeToFile(String s) throws IOException
    {

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(s);
        bufferedWriter.newLine();
        bufferedWriter.close();

    }

}