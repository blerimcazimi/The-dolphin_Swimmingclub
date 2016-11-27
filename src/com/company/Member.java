package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.Date;


public class Member {

    private ArrayList<MembersInformation> membersInfo = new ArrayList<>();
    private Date date = new Date();

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

            System.out.println("Vælg medlemskabstype: ");
            System.out.println("Vælg 1: for standart medlemskab. 2 for elitesvømmer medlemskab");
            int Type = Integer.parseInt(keyboard.nextLine());

            switch (Type)
            {

                case 1:
                    membersInfo.add(new MembersInformation(membersName, memberAge, " Standard medlemskab", date));
                    break;

                case 2:
                    membersInfo.add(new MembersInformation(membersName, memberAge, "Elitesvømmer", date));
                    break;
            }


            System.out.println("Vil du tilføje et nyt medlem (Y/N)?");

            String cont = keyboard.nextLine();

            if (cont.equalsIgnoreCase("N"))
                break;
        }

        for (int i = 0; i < membersInfo.size(); i++) {

            file.writeToFile("Medlems navn: " + membersInfo.get(i).getMemberName() + ".  Medlemmets alder: "
                    + membersInfo.get(i).getMemeberAge() + " år " + " Medlemstype: " + membersInfo.get(i).getMembershipType() + ". Dato oprettet " + date + "\n \n");


        }
    } // end of createMember

    public void coach() throws FileNotFoundException {

        System.out.println("Liste over elitesvømmere:");

        Read r = new Read();
        r.specificKeyword();

    }


    public void loginFuntion() throws IOException {

        Read read = new Read();

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

                System.out.println("Du har følgende muligheder: ");
                System.out.println("Tast 1 for at oprette nyt medlem");
                System.out.println("Tast 2 for at se liste over alle medlemmer");


                int opret = Integer.parseInt(scanner.nextLine());

                switch (opret) {

                    case 1:
                        createMember();

                        System.out.println("Vil du se liste over alle medlemmer (Y/N)?");
                        String ans = scanner.nextLine();

                        if (ans.equalsIgnoreCase("Y"))
                            read.returnfile();

                        break;

                    case 2:
                        read.returnfile();
                        break;

                }



                break; //stops the while-loop

            } else if (email.equals("123") && password.equals("321")) {

                System.out.println("du er kasser");
                System.out.println("Tryk 1 for at se liste over alle medlemmer");
                System.out.println("Tryk 2 for at se om nogen er bagud med betaling.");

                int whatToSee = Integer.parseInt(scanner.nextLine());

                switch (whatToSee) {

                    case 1:
                        read.returnfile();
                        break;

                    case 2:
                        read.yearContains();
                        break;

                }


                break; //stops the while-loop


            } else if (email.equals("12") && password.equals("32")) {

                System.out.println("Du er logget ind som træner");
                System.out.println();

                System.out.println("Tryk 1 for at se liste over alle elite svømmere");
                System.out.println("Tryk 2 for at se definere hvem der er top 5");
                String userAns = scanner.nextLine();


                if (userAns.equalsIgnoreCase("1")) {
                    coach();
                } else if (userAns.equalsIgnoreCase("2")) {

                    coach();
                    read.updateResults();




                }


                break; //stops the while-loop

//            } else {
//                System.out.println("Login fejl... prøv igen");
//            }


            }

        }
    }
}
