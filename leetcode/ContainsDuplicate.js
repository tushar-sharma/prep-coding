/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    
    if (nums.length == 1){
        return false;
    }
    
    const map1 = new Map();
    
    for (let i = 0; i < nums.length; i++) {
        if(map1.get(nums[i]) != undefined) {
            return true;
        } else {
            map1.set(nums[i], 1);
        }
    }
    
    return false;
    
};
