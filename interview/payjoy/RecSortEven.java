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
    public static List<Integer> mergeSort(List<Integer> testInput, int left, int right) {
        //TODO: remember the base condition
        if (left >= right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        mergeSort(testInput, left, mid );

        mergeSort(testInput, mid + 1, right);

        return merge(testInput, left, mid, mid + 1, right);

    }


    /*combine arrays */
    public static List<Integer> merge(List<Integer> testInput, int left1, int right1, int left2, int right2) {
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

        return auxInput;

    }

    /*
     * Sorts the array
     */
    //TODO: remember to Use List in the parameter of ArrayList
    public static List<Integer> cusSort(List<Integer> testInput) {
        //TODO: remember length of array list
        return mergeSort(testInput, 0, testInput.size() - 1);
    }

    public static void main(String[] args) {

        //create test input
        List<Integer> testInput = new ArrayList<Integer>(
                                                       Arrays.asList(2, 6, 8, 10, 1, 1, 7)
                                  );

        for(int iter : testInput) {
            System.out.print(iter + " ");
        }

        System.out.println("");

        testInput = cusSort(testInput);

        for(int iter : testInput) {
            System.out.print(iter + " ");
        }

        System.out.println("");

    }
}
