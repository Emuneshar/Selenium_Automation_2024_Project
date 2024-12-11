package Day2_10222024;

import java.util.ArrayList;

public class T3_ForLoops {
    public static void main(String[] args) {
        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA"); // positoin 0
        countries.add("Canada"); // 1
        countries.add("Bangladesh"); // 2
        countries.add("India"); // 3



//          start      end                   how to get there
        for(int i = 1; i < countries.size();   i++){
            // Loop statement goes here
            System.out.println("The country is " +countries.get(i));
        }// end of loop






        String [] cities = new String[] {"Brooklyn", "Queens", "Manhattan"};
        for(int i = 0; i < cities.length; i++){
            System.out.println("The cities are " + cities[i]);
        }



    }// End of Method
}// End of Class
