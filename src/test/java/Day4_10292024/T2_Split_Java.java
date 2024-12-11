package Day4_10292024;

public class T2_Split_Java {
    public static void main(String[] args) {
        // Print out only John from the String message "My name is John"

        // Store the message in a string variable
        String message = "My name is John";

        // Use the split funciton to separate the words apart
        String [] splitMessage = message.split(" ");

        // Print out the name John from the resulting array
        System.out.println("Value is " +splitMessage[3]);


    }// End of main method
}// End of class
