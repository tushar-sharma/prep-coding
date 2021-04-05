/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static boolean recCheckSum(TreeNode curr,  int accumulator, int targetSum) {

        if (curr == null) {
            return false;
        }

        accumulator += curr.val;

        if (accumulator == targetSum && curr.left == null && curr.right == null) {
            return true;
        }

        return recCheckSum(curr.left, accumulator, targetSum)  || recCheckSum(curr.right, accumulator, targetSum);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)  {
            return false;
        }

        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        return recCheckSum(root.left, root.val, targetSum)  || recCheckSum(root.right, root.val, targetSum);


    }
}
