package Day5_11042024;

public class T3_MultipleConditions {
    public static void main(String[] args) {
        // Declare the integer variables
        int a = 1;
        int b = 2;
        int c = 3;

        // Use Case: Print when a+b is less than c, a+b is greater than c and a+b is equal to c
        if(a+b < c){
            System.out.println("A and B is less than c");
        }
        else if(a+b > c){
            System.out.println("A and B is greater than c");
        }
        else{
            System.out.println("A and B is equal to c");
        }
    } // End of main method
} // End of class
