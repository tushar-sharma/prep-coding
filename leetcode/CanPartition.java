/**
 Things to remember:
 1. use streams to find sum
 2. Iterate over a hashset
 3. Copy a hashset to another HashSet
 */
class Solution {
    public boolean canPartition(int[] nums) {

        // sum of all elementes in array
        int target = Arrays.stream(nums).sum();

        if (target % 2 != 0  || nums.length ==1){
            return false;
        }

        Set<Integer> dp = new HashSet<>();

        dp.add(0);
        dp.add(nums[0]);
        target = target / 2;

        for (int i = 1; i  < nums.length; i++) {

            Iterator<Integer> iter = dp.iterator();

            Set<Integer> tempDp = new HashSet<>();

            while (iter.hasNext()) {

                int val = iter.next();

                if (val + nums[i]  == target) {
                    return true;
                }

                tempDp.add(val + nums[i]);
                tempDp.add(val);
            }

            dp = tempDp;
        }

        return dp.contains(target) ? true : false;

    }
}
