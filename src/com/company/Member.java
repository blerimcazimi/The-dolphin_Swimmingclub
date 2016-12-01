package com.company;

import java.io.*;
import java.util.*;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.Date;

public class Member
{

    private ArrayList<MembersInformation> membersInfo = new ArrayList<>();
    private Date date = new Date();


    public void getList()
    {

        try
        {

            BufferedReader br = new BufferedReader(new FileReader("MembersInfo.txt"));

            String lines = ""; //holds the lines of file.

            //loop through all lines.
            String line;

            ArrayList<Integer> lister = new ArrayList<Integer>();

            while ((line = br.readLine()) != null)
            {

                String[] getOld = line.split("Alder: ");
                getOld = getOld[1].split(" år"); //now we can output old by getOld[0]...

                int getOlds = Integer.parseInt(getOld[0]);

                if(18 > getOlds)
                {
                    //System.out.println("1000 kr");
                    lister.add(1000);
                } else if(getOlds >= 18 && 60 > getOlds)
                {
                    //System.out.println("1600 kr");
                    lister.add(1600);
                } else {
                    //System.out.println("1200 kr");
                    lister.add(1200);
                }

                //System.out.println(line);

            }


            Collections.sort(lister);

            for(int i = 0; lister.size() > i; i++)
            {
                System.out.println(lister.get(i));
            }


        } catch(IOException Exception)
        {
            System.out.println("Something went wrong, when we tried to replace.");
        }


    }

    public void deleteMember()
    {
        //code for deleting a member.
    }

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

            System.out.print("Indtast CPR nummer: ");
            String cpr = keyboard.nextLine();

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

                    membersInfo.add(new MembersInformation(membersName, memberAge, " Standard medlemskab", cpr, memberType, date));
                    break;

                case 2:
                    membersInfo.add(new MembersInformation(membersName, memberAge, "Elitesvømmer", "18", cpr, date));
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

            file.writeToFile("CPR: " + membersInfo.get(i).getMemberCpr() + " Navn: " + membersInfo.get(i).getMemberName() + ".  Alder: "
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

        System.out.println("Indtast CPR-nr på det medlem du vil redigere i");

        Scanner scanner = new Scanner(System.in);

        Read r = new Read();

        String cpr = scanner.nextLine();
        String found = r.specificKeyword(cpr);

        boolean runSearch = true;
        if(found.equals(""))
        {
            System.out.println("Ingen resultater fundet ved søgningen...");
            runSearch = false;
        } else {

            System.out.println("Medlem fundet baseret på din søgning:");
            System.out.println(found);

        }

        //keep looping until it breaks.
        File file = new File("membersInfo");

        while(runSearch)
        {
            System.out.println("Vil du ændre medlemmets navn?");
            System.out.println("1 for ja, og 2 for nej");

            if(scanner.next().equals("1"))
            {
                System.out.println("Indtast navn...");


                String[] getName = found.split("Navn: ");
                getName = getName[1].split("Alder:"); //now we can output name by getName[0]...

                file.replaceWith(getName[0],scanner.next() + " ", cpr);

            }

            System.out.println("Vil du ændre medlemmets alder?");
            System.out.println("1 for ja, og 2 for nej");

            if(scanner.next().equals("1"))
            {

                System.out.println("Indtast alder...");

                String[] getOld = found.split("Alder: ");
                getOld = getOld[1].split("Medlemstype"); //now we can output old by getOld[0]...

                file.replaceWith(getOld[0], scanner.next() + " år ", cpr);


            }

            System.out.println("Vil du ændre medlemmets CPR nr?");
            System.out.println("1 for ja, og 2 for nej");

            if(scanner.next().equals("1"))
            {

                System.out.println("Indtast det nye CPR...");

                String[] getCpr = found.split("CPR: ");
                getCpr = getCpr[1].split("Navn:"); //now we can output old by getOld[0]...

                file.replaceWith(getCpr[0], scanner.next() + " ", cpr);

            }

            //output...
            System.out.println("De indtastede ændringer er gemt for medlemmet.");

            break;

        }


    }


    //login to system
    public void login() throws IOException {

        Read read = new Read();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {

            System.out.println("Login med dine oplysninger");
            System.out.println("Indtast email");

            String email = scanner.nextLine();

            System.out.println("Indtast adgangskode");

            String password = scanner.nextLine();

            //check login...
            if (email.equals("formand") && password.equals("formand"))
             {

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

            } else if (email.equals("123") && password.equals("321"))
            {

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

