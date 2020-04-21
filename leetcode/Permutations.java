import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static void swap(int[] nums, int prev, int next) {
        int temp = nums[prev];
        nums[prev] = nums[next];
        nums[next] = temp;
    }

    public static void permuteRec(int[] nums, int n, List<List<Integer>> output) {

        if (n == 1) {
            System.out.println(Arrays.toString(nums));

        } else {

            for (int i = 0; i < n; i++) {
                swap(nums, i, n - 1); //remove the ith element

                permuteRec(nums, n -1, output);

                swap(nums, i, n - 1); //restore for next round
            }
        }
    }

    public static void permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();

        permuteRec(nums, nums.length, output);
    }

    public static void main(String[] args) {

        permute(new int[]{1, 2, 3});
    }
}
