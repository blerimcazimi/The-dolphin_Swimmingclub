package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Thomas on 22-11-2016.
 */
public class Read {



    private Scanner scanner = new Scanner(new File(("MembersInfo.txt")));

    public Read() throws FileNotFoundException {

    }

    public void returnfile () {
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    public void specificKeyword() {
        //System.out.println("Indtast keyword");

        while (scanner.hasNext()){
            String keyword = scanner.nextLine();
            if(keyword.contains("Elitesvømmer")){
                System.out.println(keyword);
                System.out.println();
            }
        }



    }
    public void yearContains(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Indtast årstal du vil se hvornår medlemmer sidst har betalt");
        String userInput = keyboard.nextLine();

        while(scanner.hasNext()) {

            String keyword = scanner.nextLine();

            if(keyword.contains(userInput)) {
                System.out.println(keyword);
                System.out.println();
            }

        }

    } public void updateResults() throws IOException {


        System.out.println("Skriv navnet på ham/hende du vil opdaterer svømmetider for");

        Scanner keyboard = new Scanner(System.in);
        Scanner key2 = new Scanner(System.in);
        String userInput = keyboard.nextLine();

        while (scanner.hasNext()) {

            String keyword = scanner.nextLine();

            if (keyword.contains(userInput)) {
                System.out.println("Indtast svømmeresultater på " + userInput);
                double swimResults = key2.nextDouble();

                ArrayList<Elitesvømmere> elite = new ArrayList<>();
                elite.add(new Elitesvømmere(userInput, swimResults));


            }

        }

    }

}