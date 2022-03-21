class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> result = new ArrayList<>();
        
        List<Integer> equalKey = new ArrayList<>();
        
        for (int i = 0; i <nums.length; i++){
            if (nums[i] == key){
                equalKey.add(i);
            }
        }
        
        
        for (int i = 0; i < nums.length; i++){
            for (int elem : equalKey){
                if (Math.abs(i - elem) <= k){
                    result.add(i);
                    break;
                }
            }
            
        }
        
        Collections.sort(result);
        
        return result;
    }
}