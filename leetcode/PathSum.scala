/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def checkSum(curr : TreeNode,
                 accumulator: Int,
                 targetSum : Int): Boolean = {


        if (curr == null) {
            return false;
        }

        // there's no += in scala

        if ((accumulator+curr.value) == targetSum && curr.left == null && curr.right == null) {
            return true;
        }

        return checkSum(curr.left, (accumulator+curr.value), targetSum) || checkSum(curr.right, (accumulator+curr.value), targetSum);


    }

    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {

        if (root == null){
            return false;
        }

        if (root.value == targetSum && root.left == null && root.right == null) {
            return true;
        }
        var accumulator =  root.value

        return checkSum(root.left, accumulator, targetSum) || checkSum(root.right, accumulator, targetSum);

    }
}
