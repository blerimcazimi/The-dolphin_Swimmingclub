package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.FileNotFoundException;
import java.util.Date;

public class Member extends File
{

    private ArrayList<MembersInformation> membersInfo = new ArrayList<>();
    private Date date = new Date();

    public Member() throws IOException
    {
        super("MembersInfo");
    }

    public void deleteMember() throws FileNotFoundException
    {
        //code for deleting a member.
        System.out.println("Slet et medlem ved at indtaste cpr nr.");

        Scanner scanner = new Scanner(System.in);

        String slet = scanner.nextLine();

        try
        {
            String delete = specificKeyword(slet);

            boolean runSearch = true;
            if (delete.equals(""))
            {
                System.out.println("Søgningen gav ikke nogen resultater");
                runSearch = false;
            } else {

                System.out.println("Det ønskede medlem blev fundet i datatbasen:");
                System.out.println(delete);

            }

            while (runSearch)
            {
                System.out.println("Er du sikker på at du vil slette dette medlem?");
                System.out.println("Tast 'ja' eller 'nej'");

                if (scanner.next().equals("nej"))
                {
                    break;
                } else if (scanner.next().equals("ja"))
                {

                    replaceWith(delete, " ", slet);

                    System.out.println("Medlem slettet");

                    break;
                }

            }

        } catch(IOException EX)
        {
            System.out.println("Fil ikke fundet");
        }

    }

    public void createMember() throws IOException
    {

        Scanner keyboard = new Scanner(System.in);
        while (true)
        {

            System.out.print("Indtast navn på det nye medlem: ");
            String membersName = keyboard.nextLine();

            System.out.println();
            System.out.print("Indtast alder på det nye medlem: ");
            int memberAge = Integer.parseInt(keyboard.nextLine());

            System.out.print("Indtast CPR nummer: ");
            String cpr = keyboard.nextLine();

            System.out.println();
            System.out.println("Vælg medlemets fortrukne aktivitet");
            System.out.println("Vælg \n1: for aktivt medlemskab\n2: for passivt medlemskab");
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

                    //timestamp in seconds.
                    long currentTimestamp = (System.currentTimeMillis() / 1000);

                    //there is 86400 seconds in a day (24 hour * 60 minutes * 60 seconds).
                    long secondsPerDay = 86400;

                    //seconds per year.
                    long secondsPerYear = secondsPerDay * 365;

                    //add one years timestamp to current timestamp
                    long nextYearTimestamp = secondsPerYear + currentTimestamp;

                    //convert timestamp to date. Notice: we convert the timestamp from seconds to MS again.
                    Date nextPaymentDate = new Date(nextYearTimestamp * 1000);

                    //converting the date format to yyyy-MM-dd
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    //write to file.
                    writeToFile("CPR: " + membersInfo.get(i).getMemberCpr() + " Navn: " + membersInfo.get(i).getMemberName() + ".  Alder: "
                            + membersInfo.get(i).getMemeberAge() + " år " + " Medlemsaktivitet: " + membersInfo.get(i).getMembershipType() + " Oprettet: " + date + " Betalingsdato: " + sdf.format(nextPaymentDate));

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

        System.out.println("Indtast CPR-nr på det medlem, du vil redigere");

        Scanner scanner = new Scanner(System.in);

        String cpr = scanner.nextLine();

        try {
            String found = specificKeyword(cpr);

            boolean runSearch = true;
            if (found.equals("")) {
                System.out.println("Ingen resultater fundet ved søgningen...");
                runSearch = false;
            } else {

                System.out.println("Medlem fundet baseret på din søgning:");
                System.out.println(found);

            }


            while (runSearch)
            {
                System.out.println("Vil du ændre medlemmets navn?");
                System.out.println("1 for ja, og 2 for nej");

                if (scanner.next().equals("1"))
                {
                    System.out.println("Indtast navn...");

                    String[] getName = found.split("Navn: ");
                    getName = getName[1].split("Alder:"); //now we can output name by getName[0]...

                    replaceWith(getName[0], scanner.next() + " ", cpr);

                }

                System.out.println("Vil du ændre medlemmets alder?");
                System.out.println("1 for ja, og 2 for nej");

                if (scanner.next().equals("1")) {

                    System.out.println("Indtast alder...");

                    String[] getOld = found.split("Alder: ");
                    getOld = getOld[1].split("Medlemstype"); //now we can output old by getOld[0]...

                    replaceWith(getOld[0], scanner.next() + " år ", cpr);

                }

                System.out.println("Vil du ændre medlemmets CPR nr?");
                System.out.println("1 for ja, og 2 for nej");

                if (scanner.next().equals("1")) {

                    System.out.println("Indtast det nye CPR...");

                    String[] getCpr = found.split("CPR: ");
                    getCpr = getCpr[1].split("Navn:"); //now we can output old by getOld[0]...

                    replaceWith(getCpr[0], scanner.next() + " ", cpr);

                }

                //output...
                System.out.println("De indtastede ændringer er gemt for medlemmet.");

                break;

            }

        } catch(IOException ex)
        {
            System.out.println("Fil ikke fundet");
        }


    }


}