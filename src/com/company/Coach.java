package com.company;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Coach
{

    private BufferedReader br;

    public Coach() throws IOException
    {

        br = new BufferedReader(new FileReader("Records.txt"));

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
            while ((line = br.readLine()) != null)
            {

                //put the line into the array list.
                recordsToSort.add(line);

            }

            Collections.sort(recordsToSort); //sorting all elements in our arraylist using Quicksort.

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

        } catch (IOException Ex) {
            System.out.println("Kunne ikke læse filen..");
        }

    }

    /**
     * Get a list of eliteswimmers divided into 2 list,
     * One list with swimmers >= 18 years old and a list of eliteswimmers below 18.
     */
    public void getEliteSwimmers() throws IOException
    {

        String youngSwimmers = ""; //holds list of swimmers below 18.
        String oldSwimmers = ""; //holds a list of swimmers over 18.

        //all our member information is stored into the file.
        BufferedReader br = new BufferedReader(new FileReader("MembersInfo.txt"));

        //iterate through them, where we now seperate the swimmers into two lists.
        String line;
        while ((line = br.readLine()) != null)
        {

            //getting the age of member.
            String[] getOld = line.split("Alder: ");
            getOld = getOld[1].split(" år");
            int getOlds = Integer.parseInt(getOld[0]);

            if(getOlds >= 18)
            {
                oldSwimmers += line;
            } else {
                youngSwimmers += line;
            }

        }

        //printing the swimmers out.
        System.out.println("Elitesvømmere som er 18+");
        System.out.println(oldSwimmers);

        System.out.println("");
        System.out.println("Elitesvømmere som er under 18 år");
        System.out.println(youngSwimmers);

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

        String line;

        //the file we will update.
        File Records = new File("Records");

        //all eliteswimmers is stored in the EliteSwimmers.txt file.
        BufferedReader eliteSwimmers = new BufferedReader(new FileReader("Eliteswimmers.txt"));

        //iterate through eliteswimmers.
        while ((line = eliteSwimmers.readLine()) != null)
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