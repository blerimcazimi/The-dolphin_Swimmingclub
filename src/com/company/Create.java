
package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Thomas on 21-11-2016.
 */
public class Create {


    protected ArrayList<MembersInformation> membersInfo = new ArrayList<>();

    public void createMember() throws IOException
    {

        FileClass file = new FileClass("MembersInfo");


        Scanner keyboard = new Scanner(System.in);
        while (true) {

            System.out.print("Indtast navn på nye medlem: ");
            String membersName = keyboard.nextLine();

            System.out.println();
            System.out.print("Indtast alder på nye medlem: ");
            int memberAge = Integer.parseInt(keyboard.nextLine());


            membersInfo.add(new MembersInformation(membersName, memberAge));


            System.out.println("Vil du tilføje et nyt medlem (Y/N)?");

            String cont = keyboard.nextLine();

            if (cont.equalsIgnoreCase("N"))
                break;
        }

        for (int i = 0; i < membersInfo.size(); i++) {

            file.writeToFile("Medlems navn: " + membersInfo.get(i).getMemberName() + ".\nMedlemmets alder: " + membersInfo.get(i).getMemeberAge() + " år \n\n");


        }
    }
}


