package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Read {


    private Scanner scanner = new Scanner(new File(("MembersInfo.txt")));
    private double swimResults;

    public Read() throws FileNotFoundException {

    }

    public void returnfile ()
    {

        while (scanner.hasNext())
        {
            System.out.println(scanner.nextLine());
        }

    }

    public String specificKeyword(String keywordToFind)
    {
        //System.out.println("Indtast keyword");

        while (scanner.hasNext())
        {
            String keyword = scanner.nextLine();
            if(keyword.contains(keywordToFind))
            {
                //System.out.println("found:");
                //System.out.println(keyword);
                return keyword;
            }
        }

        return "";

    }

    public void yearContains(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Indtast årstal du vil se hvornår medlemmer sidst har betalt");
        String userInput = keyboard.nextLine();

        while(scanner.hasNext()) {

            String keyword = scanner.nextLine();

            if(keyword.contains(userInput)) {
                System.out.println(keyword);
                System.out.println();
            }

        }

    } public void updateResults() throws IOException {


        System.out.println("Skriv navnet på ham/hende du vil opdaterer svømmetider for");

        Scanner keyboard = new Scanner(System.in);
        Scanner key2 = new Scanner(System.in);
        String userInput = keyboard.nextLine();

        while (scanner.hasNext()) {

            String keyword = scanner.nextLine();

            if (keyword.contains(userInput))
            {

                System.out.println("Indtast svømmeresultater på " + userInput);
                swimResults = key2.nextDouble();




                ArrayList<Elitesvømmere> elite = new ArrayList<>();
                elite.add(new Elitesvømmere(userInput, swimResults));

            }




             //  defineTop5();





            }

        }

    }


    public void defineTop5() throws FileNotFoundException {

        Scanner top5 = new Scanner(new File("Eliteswimmers.txt"));

        System.out.println("Listen over top 5: " + "\n");

     while (top5.hasNext()) {

         ArrayList<String> lines = new ArrayList<>();
         String line = top5.nextLine();
         lines.add(line);
         Collections.sort(lines);
         System.out.println(lines);

     }


    }


}