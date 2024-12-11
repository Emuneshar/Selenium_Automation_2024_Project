package Day2_10222024;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
        // Create and ArrayList for different countries
        // Print out only the third country of the List
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");


        System.out.println("My third arraylist value is " + countries.get(2));
    } // end of main
}// end of class
