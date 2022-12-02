
// Variables
// Expressions
// Conditionals
// Loops
// Functions
// Classes
// Data structure from Java Collection Framework (such as ArrayList, TreeSet, or HashMap)

// int, float, char, boolean, String

public class temp {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(addition(2, 3));
        int myArray[];
        myArray = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(sum(myArray));
        System.out.println(spliceString("Seth Wilding"));
    }

    private static int addition(int a, int b) {
        return a + b;
    }

    private static int sum(int[] numArray) {
        int total = 0;
        for (int i = 0; i < numArray.length; i++) {
            total += numArray[i];   
        }
        return total;
    }

    private static String spliceString(String name) {
        String[] splitName = name.split(" ");
        String firstName = splitName[0];
        String lastName = splitName[1];
        String nameReversed = String.format("%s, %s", lastName, firstName);
        return nameReversed;
    }



}
