package Automation_ActionItem1;

import java.util.ArrayList;

public class Assignment_Two {
    public static void main(String[] args) {
        // Created the 2 Arraylists here
        ArrayList<String> region = new ArrayList<>();
        ArrayList<Integer> areaCode = new ArrayList<>();

        // Creating mock data for region
        region.add("North");
        region.add("East");
        region.add("South");
        region.add("West");

        // Creating mock data for areaCode
        areaCode.add(215);
        areaCode.add(312);
        areaCode.add(512);
        areaCode.add(415);

        // Writing a for loop to print out the regions and area codes
        for(int x = 0; x < areaCode.size(); x++){
            System.out.println("The region is " + region.get(x) + " and the area code is " + areaCode.get(x) + ".");
        }// End of loop

    }// End of main method
}// End of class
