/**
 * Search the array for the binary search
 */

public class BinarySearch {

    /**
     * return the index of the value searched or -1 if not found
     * assumtion that array is sorted
     */
    public static int binarySearch(int[] testInput, int target) {

        int low = 0;
        int high = testInput.length -1;

        while (low <=  high) {
            int mid = low + ((high -low) / 2);

            if (testInput[mid] == target) {
                return mid;
            }
            else if (target  > testInput[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        assert binarySearch(new int[]{0, 5, 13, 19, 22, 41, 55, 68, 72, 81, 98}, 55) == 6;

        assert binarySearch(new int[]{0, 5, 13, 19}, 21) == -1;

        assert binarySearch(new int[]{5, 13, 44, 399, 722}, 722) == 4;
    }
}
