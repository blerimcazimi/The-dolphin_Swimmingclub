package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Treasurer
    {

    /**
        * Displays a list of all members, that has fallen back with payment.
     */
    public void getFallenBack()
    {
        try
        {

            BufferedReader br = new BufferedReader(new FileReader("MembersInfo.txt"));

            String line;

            //using date to find who is fallen behind.
            Date date = new Date();

            //format of date, e.g. 2016-12-01.
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            //getting todays date.
            String today = dateFormat.format(date);

            //display todays date.
            System.out.println("todays date");
            System.out.println(today);

            System.out.println("");

            try
            {

                //the payment date..
                String target = "2016-01-12";

                //parsing string into date-type.
                Date result = dateFormat.parse(target);


                //output.
                System.out.println(result);

            } catch(ParseException exception)
            {
                System.out.println("error.");
            }

            System.out.println("iterate..");
            //iterate through all members.
            while ((line = br.readLine()) != null)
            {

                String[] getPaymentDate = line.split("Betalingsdato: ");

                if(getPaymentDate.length > 1)
                {

                    System.out.println(getPaymentDate[1]);

                }

            }

        } catch (IOException exception)
        {
            System.out.println("Could not open file...");
        }

    }

    /**
     * Displays a list of all members and what they should pay for their membership.
     */
    public void getFeesList()
    {

        try
        {

            BufferedReader br = new BufferedReader(new FileReader("MembersInfo.txt"));

            System.out.println("Liste over hvad medlemmer skal betale for deres medlemskab:");

            //loop through all lines.
            String line;

            while ((line = br.readLine()) != null)
            {

                String[] getAge = line.split("Alder: ");

                //the if- fixes issues with lines with no content.
                if(getAge.length > 1)
                {

                    //get age of member
                    getAge = getAge[1].split(" år");
                    int getAges = Integer.parseInt(getAge[0]);

                    //get name of member.
                    String[] getName = line.split("Navn: ");
                    getName = getName[1].split("Alder:");

                    //get cpr of member.
                    String[] getCpr = line.split("CPR: ");
                    getCpr = getCpr[1].split("Navn:");

                    //get membership..
                    String[] getMembership = line.split("Medlemsaktivitet: ");
                    getMembership = getMembership[1].split(" Oprettet:");

                    //the logic handler for their fee.
                    if(getMembership[0].equals("Passiv"))
                    {

                        System.out.print("500 kr");

                    } else if (18 > getAges)
                    {
                        System.out.print("1000 kr");
                    } else if (getAges >= 18 && 60 > getAges)
                    {
                        System.out.print("1600 kr");
                    } else {
                        //over 60 years.
                        System.out.print("1200 kr");
                    }

                    //display...
                    System.out.println(" - Navn: " + getName[0] + " -  CPR: " + getCpr[0] + " - Medlemskab: " + getMembership[0]);

                }

            }


        } catch(IOException Exception)
        {
            System.out.println("Something went wrong, when we tried to get a list.");
        }

    }

}


