package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Coach extends File
{

    public Coach() throws IOException
    {

        super("Records");

    }

    /**
     * The method displays the top 5 best swimmers.
     * All of the records is being added (from txt) into a arraylist, where we use Quick sort,
     * to sort the records in ASC-order, and lastly we display them.
     */
    public void getBestSwimmers() {

        try
        {

            //the array will hold all lines in the txt file, and sort them.
            ArrayList<String> recordsToSort = new ArrayList<String>();

            //iterate through all records.
            String line;
            BufferedReader br = readFile();
            while ((line = br.readLine()) != null)
            {

                //put the line into the array list.
                recordsToSort.add(line);

            }

            //sorting all elements in our arraylist using Quicksort.
            Collections.sort(recordsToSort);

            //the elements is now sorted, we're now iterating through dem, and using System out, to display them.
            for (int i = 0; recordsToSort.size() > i; i++)
            {

                System.out.println(recordsToSort.get(i));

                //if i is equal to 5, we break the loop. (We're only interested in the top-5 best).
                if (i == 4)
                {
                    break;
                }

            }

        } catch (IOException Ex)
        {
            System.out.println("Kunne ikke læse filen..");
        }

    }

    /**
     * Get a list of eliteswimmers divided into 2 list,
     * One list with swimmers >= 18 years old and a list of eliteswimmers below 18.
     */
    public void getEliteSwimmers() throws IOException
    {

        String eliteSwimmers = ""; //holds list of swimmers below 18.
        String juniorSwimmers = ""; //holds a list of swimmers over 18.

        //all our member information is stored into the file.
        File file = new File("MembersInfo");

        //iterate through them, where we now seperate the swimmers into two lists.
        String line;
        BufferedReader br = readFile();
        while ((line = br.readLine()) != null)
        {

            //getting the age of member.
            String[] getOld = line.split("Alder: ");
            getOld = getOld[1].split(" år");
            int getOlds = Integer.parseInt(getOld[0]);

            if(getOlds >= 18)
            {
                eliteSwimmers += line;
            } else {
                juniorSwimmers += line;
            }

        }

        //printing the swimmers out.
        System.out.println("Elitesvømmere (18+)");
        System.out.println(eliteSwimmers);

        System.out.println("");
        System.out.println("Junior team (below 18)");
        System.out.println(juniorSwimmers);

    }

    /**
     * Update result for a swimmer.
     * TODO: Should we display an error, if no user was found during search?
     */
    public void updateResult() throws IOException
    {

        System.out.println("Skriv CPR på den bruger du vil opdaterer svømmetider for");

        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();

        //the file we will update.
        File Records = new File("Records");

        //iterate through them, where we now seperate the swimmers into two lists.
        String line;
        BufferedReader br = readFile();
        while ((line = br.readLine()) != null)
        {

            //does line contain the input?
            if (line.contains(userInput))
            {

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();

                System.out.println("Indtast svømmeresultater på " + userInput);
                Records.writeToFile("\n" + keyboard.nextLine() + " - CPR: " + userInput + " - Dato: " + dateFormat.format(date));
                System.out.println("Svømmetid gemt.");

            }

        }

    }

}