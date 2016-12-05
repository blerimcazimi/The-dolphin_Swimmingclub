package com.company;

import java.io.*;
import java.util.*;

public class Read {


    private Scanner scanner = new Scanner(new FileReader("MembersInfo.txt"));


    public Read() throws FileNotFoundException
    {

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

    }


}