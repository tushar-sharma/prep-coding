/**
  * Search a value in rotated array
  *
  * https://leetcode.com/problems/search-in-rotated-sorted-array/
  */

public class SortedArray{

    public static int findArray(int[] testInput, int target) {
        int low = 0;
        int high = testInput.length - 1;
        int mid = 0;
        //find the pivot
        while (low <= high) {
            mid = low + (high- low) / 2;
            if (testInput[mid] > testInput[mid + 1] && testInput[mid] > testInput[mid -1] ) {
                break;
            }
            else if (testInput[mid] > testInput[0]) {
                low = mid + 1;
            } else  {
                high = mid - 1;
             }
        }

        int pivot = mid;

        if (testInput[pivot] == target)
            return pivot;

        if(target >= testInput[0] && target <= testInput[pivot - 1]) {
            low = 0;
            high = pivot - 1;
        } else {
            low = pivot +1;
            high = testInput.length - 1;
        }

        while (low < high) {
            mid = low + (high - low) / 2;
            if (testInput[mid] == target) {
                return mid;
            } else if (testInput[mid] > target) {
                high  = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        if (low == high) {
            if (testInput[low] == target) {
                return low;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr =  {4, 5, 6, 7, 0, 1, 2};

        assert findArray(arr, 0) == 4;

        assert findArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1;

        assert findArray(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 2) == 8;

        assert findArray(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 7) == 1;

        assert findArray(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 6) == 0;
    }
}
