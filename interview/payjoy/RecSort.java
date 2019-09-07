import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/*recursively sort the array
 * also even numbers are sorted before odd number*/
public class RecSort {

    public static List<Integer> recSort(List<Integer> testInput, int left, int right) {

        if (left >= right)
            return null;

        int mid =  left + ((right - left) / 2);

        recSort(testInput, left, mid);

        recSort(testInput, mid + 1, right);

        return merge(testInput, left, mid,  mid + 1, right);
    }

    public static List<Integer> merge(List<Integer> testInput, int left1, int right1, int left2, int right2) {
        List<Integer> auxList = new ArrayList();

        int iter1 = left1, iter2 = left2;

        while (iter1 <= right1 && iter2 <= right2) {
            if (testInput.get(iter1) < testInput.get(iter2)) {
                auxList.add(testInput.get(iter1++));
            } else {
                auxList.add(testInput.get(iter2++));
            }
        }

        while (iter1 <= right1) {
            auxList.add(testInput.get(iter1++));
        }

        while(iter2 <= right2) {
            auxList.add(testInput.get(iter2++));
        }

        return auxList;
    }

    public static List<Integer> customSort(List<Integer> testInput) {

        //TODO: remember length of arraylist
        return recSort(testInput, 0, testInput.size() - 1);

    }

    public static void main(String[] args) {
        List<Integer> testInput = new ArrayList<Integer>(Arrays.asList(2, 6, 8, 10, 1, 1, 7));

        testInput = customSort(testInput);

        for (int iter : testInput) {
            System.out.print(iter + " ");
        }

        System.out.println(" ");
    }
}
