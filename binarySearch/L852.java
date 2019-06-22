/*
 * Leetcode problem 852 : https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

public class L852 {

    /**
     * @return index i where A(i) gt A(i+1)
     * Uses linear scan O(n)
     */
    public static int peakLS(int[] arr) {

        if (arr.length < 3)
            return -1;

        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[i] < arr[i - 1]) {
                return (i-1);
            }
        }

        return -1;
    }

    /**
     * @return index i where A(i) gt A(i + 1)
     * Uses binary search O(logn)
     */
    public static int peakBS(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length - 1;

        while (low <= high) {
            //round down
           int mid = low + (high - low) / 2;

           int left = arr[mid - 1];
           int right = arr[mid  + 1];

           if (mid == 0 || left < arr[mid] && ((n-1) ==  mid || right < arr[mid])) {
               return mid;
           }
           else if (mid > 0 && arr[mid - 1] > arr[mid]) {
               high = mid - 1;
           } else {
               low = mid + 1;
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        assert peakLS(new int[]{0,1, 0}) == 1;

        assert peakLS(new int[]{0, 2, 5 , 4, 3, 2, 1}) == 2;

        assert peakBS(new int[]{0,1, 0}) == 1;

        assert peakBS(new int[]{0, 2, 5 , 4, 3, 2, 1}) == 2;

    }
}
