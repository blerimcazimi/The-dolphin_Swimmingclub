package com.company;

import java.io.*;
import java.util.*;

public class Read {




    public void returnfile (String s) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(s));

        while (scanner.hasNext())
        {
            System.out.println(scanner.nextLine());
        }


    }

    public String returnTop5file(String s) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(s));

        while (scanner.hasNext())
        {
          return scanner.nextLine();
        }

return "";
    }


    public String specificKeyword(String keywordToFind, String fileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(fileName));

        while (scanner.hasNext())
        {
            String keyword = scanner.nextLine();
            if(keyword.contains(keywordToFind))
            {

                return keyword;
            }
        }

        return "";

    }


    public void yearContains() throws FileNotFoundException {

       Scanner scanMembersInfo = new Scanner(new FileReader("MembersInfo.txt"));

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Indtast årstal du vil se hvornår medlemmer sidst har betalt");
        String userInput = keyboard.nextLine();

        while(scanMembersInfo.hasNext()) {

            String keyword = scanMembersInfo.nextLine();

            if(keyword.contains(userInput)) {
                System.out.println(keyword);
                System.out.println();
            }

        }

    }

}