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

    public static boolean recCheckSum(TreeNode curr,
                              int accumulator,
                              int targetSum,
                              List<List<Integer>> paths,
                              List<Integer> parent) {

        if (curr == null) {
            return false;
        }

        accumulator += curr.val;

        parent.add(curr.val);

        if (accumulator == targetSum && curr.left == null && curr.right == null) {
            paths.add(parent);
            return true;
        }


        recCheckSum(curr.left, accumulator, targetSum, paths, new ArrayList(parent));

        recCheckSum(curr.right, accumulator, targetSum, paths,  new ArrayList(parent));

        return false;

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        //prep-coding add
        List<List<Integer>> paths = new ArrayList<>();


        if (root == null) {

            return paths;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {

            List<Integer> temp = new ArrayList<>();

            temp.add(root.val);

            paths.add(temp);

            return paths;
        }


        List<Integer> parent = new ArrayList<>();
        parent.add(root.val);

        recCheckSum(root.left, root.val, targetSum, paths, new ArrayList(parent));

        recCheckSum(root.right, root.val, targetSum, paths, new ArrayList(parent));

        return paths;

    }
}

