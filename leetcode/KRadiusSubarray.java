/**
 * Things to remember
 * 1. array initialization with default values
 * 
 */
import java.util.Arrays;
class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, -1);

        if (k > n){
            return output;
        }

        double sumLeft = 0;
        for (int i = 0; i < k; i++) {
            sumLeft += nums[i];
        }

        double sumRight = 0;
        for (int i = k + 1 ; i <= 2 * k ; i++){
            if (i < n) {
                sumRight += nums[i];
            }
        }

        int totalElement = 2 * k + 1;

        for (int i = k; i < n - k; i++) {
            double sum = (sumLeft + sumRight + nums[i]) / totalElement;
            output[i] = (int) sum;

            sumLeft = sumLeft + nums[i];

            if (i - k >= 0 ){
                sumLeft -= nums[i - k] ;
            }

            if (i + 1 < n ) {
                sumRight = sumRight - nums[i + 1];
            }

            if (i + k + 1 < n){
                sumRight = sumRight  + nums[ i + k + 1];
            }

        }

        return output;

    }
}
