package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Member member = new Member();
        member.login();

        Read r = new Read();

        System.out.println("Vil du se oversigten over alle registrede medllemer (Y/N)?");
        Scanner keyboard = new Scanner(System.in);
        String oversigtAnswer = keyboard.nextLine();

        if(oversigtAnswer.equalsIgnoreCase("Y"))
            r.returnfile();

    }
}