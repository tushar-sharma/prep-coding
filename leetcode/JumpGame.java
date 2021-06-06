class Solution {

    public static boolean dfs(int start, int[] nums, Set<Integer> visited){

        if (start >= nums.length){
            return false;
        }

        if (start == nums.length - 1){
            return true;
        }

        visited.add(start);

        boolean output = false;

        for (int i = nums[start]; i > 0 ; i--) {
            if (!visited.contains(start + i) && start < nums.length){
                output = dfs(start + i, nums, visited);
            }
            if (output == true){
                return output;
            }
        }

        return output;

    }

    public boolean canJump(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        return dfs(0, nums, visited);

    }
}
