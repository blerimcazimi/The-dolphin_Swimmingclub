package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

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

            //get current timestamp (amount of seconds since 1980 till now).
            long currentTimestamp = (System.currentTimeMillis() / 1000);

            //iterate through all members.
            while ((line = br.readLine()) != null)
            {

                String[] getPaymentDate = line.split("Betalingsdato: ");

                if(getPaymentDate.length > 1)
                {

                    //converting payment date to timestamp.
                    String paymentDate = getPaymentDate[1] + " 00:00:00"; // (the timestamp object requires hour, minutes and secounds).

                    //convert string to timestamp
                    Timestamp time = Timestamp.valueOf(paymentDate);

                    //convert timestamp milli seconds to secounds.
                    long paymentTimestamp = (time.getTime() / 1000);

                    //current timestamp is greater than paymentTimestamp (the member has fallen behind).
                    if(currentTimestamp > paymentTimestamp)
                    {

                        String[] getName = line.split("Navn: ");
                        getName = getName[1].split(" Alder:"); //now we can output name by getName[0]...

                        System.out.println(getName[0] + " er bagud med betalingen. Betalingsdato: " + getPaymentDate[1]);

                    }

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


