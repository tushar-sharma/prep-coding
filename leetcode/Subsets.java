/**
 * Notes
 *
 * Create a list of list
 * List<List<Integer>> foo = new ArrayList<>();
 *
 * Print an integer array for debugging
 * System.out.println(Arrays.toString(array));
 *
 * Print an ArrayList for debugging
 * System.out.println(list.toString())
 *
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //number of subsets
        int number_of_subsets = (int) Math.pow(2, nums.length);

        List<List<Integer>> output = new ArrayList<>();

        output.add(new ArrayList<>());


        for (int i = 1; i < number_of_subsets; i++) {

            int cur = i;
            int index = 0;
            int[] indices = new int[nums.length];

            // convert decimal to binary
            while (cur > 0){

                if (cur % 2 != 0) {
                    indices[index] = 1;
                }
                index++;
                cur = cur / 2;
            }
            List<Integer> interOutput = new ArrayList<>();

            for (int j = indices.length - 1; j >= 0; j--) {
                if (indices[j] == 1)
                    interOutput.add(nums[nums.length - j - 1]);
            }
            output.add(interOutput);
        }

        return output;
    }
}
