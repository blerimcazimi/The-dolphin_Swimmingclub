package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        while(true)
        {

            System.out.println("Login med dine oplysninger");
            System.out.println("Indtast email");

            String email = scanner.nextLine();

            System.out.println("Indtast adgangskode");

            String password = scanner.nextLine();

            //check login <3
            if(email.equals("formand") && password.equals("formand"))
            {

                System.out.println("Du er FORMANDEN !!!");
                break; //stops the while-loop

            } else if(email.equals("123") && password.equals("321"))
            {

                System.out.println("du er kasser...");
                break; //stops the while-loop


            } else if(email.equals("12") && password.equals("32"))
            {
                System.out.println("du er træner...");
                break; //stops the while-loop

            } else {
                System.out.println("Login fejl... prøv igen");
            }

        }

    }

}
