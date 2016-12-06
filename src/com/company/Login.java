package com.company;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by blerimcazimi on 06/12/2016.
 */
public class Login extends Member
{

    //login to system
    public Login() throws IOException
    {


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

                            File file = new File("MembersInfo");
                            file.systemOutFile();

                        }

                        break;

                    case 2:

                        File file = new File("MembersInfo");
                        file.systemOutFile();

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
                System.out.println("Tryk 2 for at se hvem der er top 5");
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
