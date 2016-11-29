package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.Date;

public class Member
{

    private ArrayList<MembersInformation> membersInfo = new ArrayList<>();
    private Date date = new Date();


    public void deleteMember()
    {
        //code for deleting a member.
    }

    public void createMember() throws IOException
    {

        PrintFile file = new PrintFile("MembersInfo");

        Scanner keyboard = new Scanner(System.in);
        while (true)
        {

            System.out.print("Indtast navn på nye medlem: ");
            String membersName = keyboard.nextLine();

            System.out.println();
            System.out.print("Indtast alder på nye medlem: ");
            int memberAge = Integer.parseInt(keyboard.nextLine());

            System.out.println();
            System.out.println("Vælg medlemets fortrukne aktivitet");
            System.out.println("Vælg 1: for aktivt medlemskab\n2 for passivt medlemskab");
            String memberType = "";
            int memberTypeSwitch = Integer.parseInt(keyboard.nextLine());
            switch (memberTypeSwitch)
            {

                case 1:

                    memberType = "Aktivt";
                    break;

                case 2:
                    memberType = "Passiv";
                    break;
            }

            System.out.println("Vælg medlemskabstype: ");
            System.out.println("Vælg 1: for standart medlemskab\n2 for elitesvømmer medlemskab");
            int Type = Integer.parseInt(keyboard.nextLine());

            switch (Type)
            {

                case 1:

                    membersInfo.add(new MembersInformation(membersName, memberAge, " Standard medlemskab", memberType, date));
                    break;

                case 2:
                    membersInfo.add(new MembersInformation(membersName, memberAge, "Elitesvømmer", memberType, date));
                    break;
            }


            System.out.println("Vil du tilføje et nyt medlem (Y/N)?");

            String cont = keyboard.nextLine();

            if (cont.equalsIgnoreCase("N"))
            {
                break;
            }

        }

        //Putting all the added members from our arraylist into the file.
        for (int i = 0; i < membersInfo.size(); i++)
        {

            file.writeToFile("Navn: " + membersInfo.get(i).getMemberName() + ".  Alder: "
                    + membersInfo.get(i).getMemeberAge() + " år " + " Medlemstype: " + membersInfo.get(i).getMembershipType() + ". Medlemsaktivitet: " + membersInfo.get(i).getMembershipActivity() + ". Oprettet: " + date + "\n \n");

        }

    } // end of createMember


    //get list of coaches.
    public void coach() throws FileNotFoundException
    {

        System.out.println("Liste over elitesvømmere:");

        Read r = new Read();
        r.specificKeyword("Elitesvømmer");

    }

    //edit member
    public void editMember() throws FileNotFoundException
    {

        System.out.println("Indtast navnet på det medlem du vil redigere i");

        Scanner scanner = new Scanner(System.in);

        Read r = new Read();
        r.specificKeyword(scanner.nextLine());

    }


    //login to system
    public void login() throws IOException {

        Read read = new Read();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Login med dine oplysninger");
            System.out.println("Indtast email");

            String email = scanner.nextLine();

            System.out.println("Indtast adgangskode");

            String password = scanner.nextLine();

            //check login...
            if (email.equals("formand") && password.equals("formand")) {

                System.out.println("Du er logget ind som formanden");

                System.out.println("Du har følgende muligheder: ");
                System.out.println("Tast 1 for at oprette nyt medlem");
                System.out.println("Tast 2 for at se liste over alle medlemmer");
                System.out.println("Tast 3 for at redigere et medlem");
                System.out.println("Tast 4 for at slette et medlem");

                int opret = Integer.parseInt(scanner.nextLine());

                switch (opret) {

                    case 1:

                        createMember();

                        System.out.println("Vil du se liste over alle medlemmer (Y/N)?");
                        String ans = scanner.nextLine();

                        if (ans.equalsIgnoreCase("Y"))
                        {
                            read.returnfile();
                        }

                        break;

                    case 2:
                        read.returnfile();
                        break;

                    case 3:

                        editMember();
                        break;

                    case 4:

                        deleteMember();
                        break;

                }

                break; //stops the while-loop

            } else if (email.equals("123") && password.equals("321")) {

                System.out.println("du er kasser");
                System.out.println("Tryk 1 for at se liste over alle medlemmer");
                System.out.println("Tryk 2 for at se om nogen er bagud med betaling.");

                int whatToSee = Integer.parseInt(scanner.nextLine());

                switch (whatToSee)
                {

                    case 1:
                        read.returnfile();
                        break;

                    case 2:
                        read.yearContains();
                        break;

                }


                break; //stops the while-loop


            } else if (email.equals("12") && password.equals("32"))
            {

                System.out.println("Du er logget ind som træner");
                System.out.println();

                System.out.println("Tryk 1 for at se liste over alle elite svømmere");
                System.out.println("Tryk 2 for at se definere hvem der er top 5");
                String userAns = scanner.nextLine();


                if (userAns.equalsIgnoreCase("1"))
                {
                    coach();
                } else if (userAns.equalsIgnoreCase("2"))
                {

                    coach();
                    read.updateResults();

                }

                break; //stops the while-loop

            } else {
                System.out.println("Login fejl... prøv igen");
           }


            }

        }
    }

