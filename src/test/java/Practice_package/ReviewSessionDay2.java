package Practice_package;

public class ReviewSessionDay2 {
    public static void main(String[] args) {
        String [] states = new String[]{"NY", "PA", "NJ", "OH", "WY"};

        int [] zipcodes = new int [] {10001, 10002, 10003, 10004, 10005};

        for(int i = 0; i < 5; i++){
            System.out.println("My state is " + states[i] + " My zipcode is " + zipcodes[i]);
        }
    }
}
