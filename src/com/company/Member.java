package com.company;

import java.io.IOException;
import java.util.*;

import java.io.FileNotFoundException;
import java.util.Date;

public class Member
{

    private ArrayList<MembersInformation> membersInfo = new ArrayList<>();
    private Date date = new Date();


    public void deleteMember() throws FileNotFoundException
    {
        //code for deleting a member.
        System.out.println("Slet et medlem ved at indtaste cpr nr.");

        Scanner scanner = new Scanner(System.in);

        Read r = new Read();

        String slet = scanner.nextLine();
        String delete = r.specificKeyword(slet);

        boolean runSearch = true;
        if(delete.equals(""))
        {
            System.out.println("Søgningen gav ikke nogen resultater");
            runSearch = false;
        } else {

            System.out.println("Det ønskede medlem blev fundet i datatbasen:");
            System.out.println(delete);

        }

        File file = new File("MembersInfo");

        while(runSearch)
        {
            System.out.println("Er du sikker på nat du vil slette dette medlem?");
            System.out.println("Tast 'ja' eller 'nej'");

            if(scanner.next().equals("nej")){
                break;
            } else if(scanner.next().equals("ja"))
            {

                file.replaceWith(delete, " ", slet);

                System.out.println("Medlem slettet");
                break;
            }

        }

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


                membersInfo.add(new MembersInformation(membersName, memberAge, memberType, cpr, date));

                //Putting all the added members from our arraylist into the file.
                for (int i = 0; i < membersInfo.size(); i++)
                {

                    file.writeToFile("CPR: " + membersInfo.get(i).getMemberCpr() + " Navn: " + membersInfo.get(i).getMemberName() + ".  Alder: "
                            + membersInfo.get(i).getMemeberAge() + " år " + " Medlemsaktivitet: " + membersInfo.get(i).getMembershipType() + " Oprettet: " + date + "\n \n");

                }

                System.out.println("Vil du tilføje et nyt medlem (Y/N)?");

                String cont = keyboard.nextLine();

                if (cont.equalsIgnoreCase("N"))
                {
                    break;
                }

            }

        }// end of createMember

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
    public void login() throws IOException
    {

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

                System.out.println("Du er logget på som kasser.");
                System.out.println("Tryk 1 for at se liste over alle medlemmer");
                System.out.println("Tryk 2 for at se om nogen er bagud med betaling.");

                int whatToSee = Integer.parseInt(scanner.nextLine());

                Treasurer treasurer = new Treasurer();

                switch (whatToSee)
                {

                    case 1:

                        treasurer.getFeesList();
                        break;

                    case 2:

                        treasurer.getFallenBack();
                        break;

                }

            } else if (email.equals("12") && password.equals("32"))
            {

                //create new object of Coach.
                Coach coach = new Coach();

                System.out.println("Du er logget ind som træner");
                System.out.println();

                System.out.println("Tryk 1 for at se liste over alle elite svømmere");
                System.out.println("Tryk 2 for at se definere hvem der er top 5");
                System.out.println("Tryk 3 for at opdatere resultater for en svømmer");
                String userAns = scanner.nextLine();

                //logic handler.
                if (userAns.equals("1"))
                {

                    coach.getEliteSwimmers();

                } else if (userAns.equals("2"))
                {

                    coach.getBestSwimmers();

                } else if(userAns.equals("3"))
                {
                    coach.updateResult();
                }

                break; //stops the while-loop

            } else {
                System.out.println("Login fejl... prøv igen");
           }


            }

        }
    }