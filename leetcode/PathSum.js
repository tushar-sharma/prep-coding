/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {boolean}
 */

var checkSum = function(curr, accumulator, targetSum) {

    if (curr === null) {
        return false;
    }

    accumulator += curr.val;

    if (accumulator == targetSum && curr.left === null && curr.right === null) {
        return true;
    }

    return checkSum(curr.left, accumulator, targetSum) || checkSum(curr.right, accumulator, targetSum);


}

var hasPathSum = function(root, targetSum) {

    if (root === null) {
        return false;
    }

    if (root.val == targetSum && root.left === null && root.right === null){
        return true;
    }

    return checkSum(root.left, root.val, targetSum) || checkSum(root.right, root.val, targetSum);

};
