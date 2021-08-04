/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {

    if (nums.length == 1){
        return true;
    }

    let lastPos = nums.length -1;

    for (let i = nums.length - 2; i >= 0 ; i--){
        if (i + nums[i] >= lastPos){
            lastPos = i;
        }
    }

    if (lastPos == 0){
        return true;
    } else {
        return false;
    }

};
