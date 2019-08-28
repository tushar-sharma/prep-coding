import java.util.Arrays;
/*
 * Sort a string
 */
public class SortAString {
    public static void main(String[] args) {

        String testInput = "testing";
        char[] testArray = testInput.toCharArray();

        //sort primitive
        Arrays.sort(testArray);

        String newTestInput = new String(testArray);

        System.out.println("Original string " + testInput);
        System.out.println("Sorted string " + newTestInput);
    }
}
