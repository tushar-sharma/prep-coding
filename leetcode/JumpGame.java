class Solution {
    public boolean canJump(int[] nums) {
        
        if (nums.length < 1 ){
            return false;
        }
        
        if (nums.length == 1){
            return true;
        }
        
        int lastPos = nums.length - 1;
        
        for (int i = nums.length -2; i >= 0; i--){
            if (nums[i] + i >= lastPos){
                lastPos = i;
            }
        }
        
        if (lastPos == 0){
            return true;
        } else {
            return false;
        }
        
    }
}