package Practice_package;

public class Reusable_Method_Example {

    public static int addition(int numOne, int numTwo){
        // we created this because we needed somewhere to save the answer
        int sum = numOne + numTwo;

        return sum;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;

        System.out.println(addition(a, b));
    }
}
