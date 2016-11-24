package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Member
{


    private ArrayList<MembersInformation> membersInfo = new ArrayList<>();

    public void createMember() throws IOException
    {

        File file = new File("MembersInfo");

        Scanner keyboard = new Scanner(System.in);

        while (true)
        {

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


    //login to the system
    public void login() throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Login med dine oplysninger");
            System.out.println("Indtast email");

            String email = scanner.nextLine();

            System.out.println("Indtast adgangskode");

            String password = scanner.nextLine();

            //check login <3
            if (email.equals("formand") && password.equals("formand")) {

                System.out.println("Du er logget ind som formanden");
                System.out.println("Skriv 'opret' for at oprette en ny bruger");
                String opret = scanner.nextLine();

                if(opret.equalsIgnoreCase("opret"))
                {
                    createMember();
                }

                break; //stops the while-loop

            } else if (email.equals("123") && password.equals("321")) {

                System.out.println("du er kasser...");
                break; //stops the while-loop


            } else if (email.equals("12") && password.equals("32")) {
                System.out.println("du er træner...");
                break; //stops the while-loop

            } else {
                System.out.println("Login fejl... prøv igen");
            }


        }

    }


}
