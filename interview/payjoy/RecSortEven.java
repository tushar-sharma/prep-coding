import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/*
 * Recursively sort the array
 * even numbers are sorted before odd arrays
 */

public class RecSortEven {

    /*check if it's even or odd*/

    public static boolean isEven(int number ) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * recursively sort the array */
    public static void mergeSort(List<Integer> testInput, int left, int right) {
        //TODO: remember the base condition
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        //System.out.println("mid is " + mid);

        mergeSort(testInput, left, mid );

        mergeSort(testInput, mid + 1, right);

        merge(testInput, left, mid, mid + 1, right);
    }


    /*combine arrays */
    public static void merge(List<Integer> testInput, int left1, int right1, int left2, int right2) {

        List<Integer> auxInput = new ArrayList<>();

        int iter1 = left1, iter2 = left2;

        while (iter1 <= right1 && iter2 <= right2) {

            //TODO: remember how to access index of ArrayList
            if (isEven(testInput.get(iter1)) && !isEven(testInput.get(iter2))) {
                auxInput.add(testInput.get(iter1++));
            } else if (isEven(testInput.get(iter2)) && !isEven(testInput.get(iter1))) {
                auxInput.add(testInput.get(iter2++));
            } else {

                if (testInput.get(iter1) < testInput.get(iter2)) {
                    auxInput.add(testInput.get(iter1++));
                } else {
                    auxInput.add(testInput.get(iter2++));
                }
            }
        }

        while (iter1 <= right1) {
            auxInput.add(testInput.get(iter1++));
        }

        while (iter2 <= right2) {
            auxInput.add(testInput.get(iter2++));
        }

        //copy the content
        //TODO: remember how to copy ArrayList from another ArrayList
        for (int i = left1; i <= right2; i++) {
            testInput.set(i, auxInput.remove(0));
        }

    }

    /*
     * Sorts the array
     */
    //TODO: remember to Use List in the parameter of ArrayList
    public static void cusSort(List<Integer> testInput) {
        //TODO: remember length of array list
        mergeSort(testInput, 0, testInput.size() - 1);
    }

    public static void main(String[] args) {

        //create test input
        List<Integer> testInput = new ArrayList<Integer>(Arrays.asList(10, 8, 1, 7, 1, 2) );

        for(int iter : testInput) {
            System.out.print(iter + " ");
        }

        System.out.println("\n\nAfter Sorting\n");

        cusSort(testInput);

        for(int iter : testInput) {
            System.out.print(iter + " ");
        }

        System.out.println("");

    }
}
