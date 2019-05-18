/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Check if binary tree is balanced */
class Solution {

    public boolean isBalanced(TreeNode root) {


        if (root == null ) {
        }

        return checkBalanced(root).isBalanced;

    }

    class Balanced {
        boolean isBalanced;
        int height;

        public Balanced(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public Balanced checkBalanced(TreeNode curr) {

        if (curr == null) {
            return new Balanced(true, -1);
        }

        Balanced leftResult = checkBalanced(curr.left);

        if (!leftResult.isBalanced) {
            return leftResult;
        }

        Balanced rightResult = checkBalanced(curr.right);

        if (!rightResult.isBalanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new Balanced(isBalanced, height);
    }

}
