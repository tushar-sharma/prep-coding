class Solution {
    /**
      * url: https://leetcode.com/problems/summary-ranges/
      * Things to remember:

      - convert integer to string
         Integer.toString(number)
     */
    public List<String> summaryRanges(int[] nums) {

        if (nums.length < 1) {
            return new ArrayList<>();
        }


        int prev = 0 ;
        int next = prev + 1;
        List<String> output = new ArrayList<>();

        for( int i = 0; i <= nums.length - 1; i++) {

            if (next < nums.length && nums[next] - nums[i] == 1) {
                next++;
            } else {

                if ((next - 1) == prev) {
                    output.add(Integer.toString(nums[prev]));

                } else {
                    String tempOutput = Integer.toString(nums[prev]) + "->" + Integer.toString(nums[next - 1]);

                    output.add(tempOutput);
                }

                prev = i + 1;
                next = prev + 1;

            }
        }

        return output;
    }
}
