
        package com.company;

        import java.io.FileNotFoundException;
        import java.util.Scanner;

/**
 * Created by Thomas on 22-11-2016.
 */
public class Read {


    private File fn = new File("MembersInfo.txt");
    private Scanner scanner = new Scanner(new java.io.File(fn.workingDir.concat("MembersInfo.txt")));

    public Read() throws FileNotFoundException {

    }

    public void returnfile () {
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

}
