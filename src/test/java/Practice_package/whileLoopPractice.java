package Practice_package;

import java.util.ArrayList;

public class whileLoopPractice {
    public static void main(String[] args) {
        ArrayList<String> food = new ArrayList<>();
        food.add("Pizza");
        food.add("Texas");
        food.add("Shah's");
        food.add("Hagendaz Ice Cream");
        //  where to start  how far to go     how to get there
        int x = 0;

        while(x < food.size()){
            System.out.println(food.get(x));
            x++;
        }
        // whatever you can do with a for loop, you can do with a while loop.
        //
    }
}
