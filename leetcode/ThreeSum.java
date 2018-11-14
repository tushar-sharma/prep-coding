/*
 * Problem: https://leetcode.com/problems/3sum/
 * Tidbit: https://stackoverflow.com/questions/6810691/instantiating-a-list-in-java
 */
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

public class ThreeSum {

    /* O(n3) */
    public static List<List<Integer>> threeSumAlgo1(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0 ){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                    }
                }
            }
        }

        return result;
    }


    /* O(n2) using two pointers*/
    public static List<List<Integer>> threeSumAlgo2(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<Integer> track = new HashSet<>();

        Arrays.sort(nums);


        for(int i = 0; i < nums.length - 2; i++) {
            //fix the value
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            while (start < end ) {

                int b = nums[start];
                int c = nums[end];

                int sum = a + b + c;

                if (start > i + 1 && (nums[start] == nums[start - 1])) {
                    start = start + 1;
                    continue;
                }

                if (sum == 0) {


                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(a);
                    tempResult.add(b);
                    tempResult.add(c);
                    result.add(tempResult);

                    start = start + 1;
                    end = end - 1;
                } else if (sum > 0 )  {
                    end = end - 1;
                } else {
                    start = start + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println("\n**Algo1\n" + threeSumAlgo1(nums));

        System.out.println("\n**Algo2\n" + threeSumAlgo2(nums));
    }
}
