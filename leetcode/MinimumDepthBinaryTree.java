/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Queue<TreeNode> qu = new LinkedList<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {

            TreeNode curr = root;

            qu.add(curr);


            while (!qu.isEmpty()) {

                TreeNode next = qu.poll();
                if (next.left != null) {
                    qu.add(next.left);
                    parent.put(next.left, next);
                }
                if (next.right != null) {
                    qu.add(next.right);
                    parent.put(next.right, next);

                }

                // found the minimum depth
                if (next.left == null && next.right == null) {

                    if (parent.isEmpty()) {
                        return 1;
                    }

                    int level = 2;
                    while (parent.get(next) != root){
                        level++;
                        next = parent.get(next);
                    }
                    return level;


                }

            }

        }
        return 0;
    }
}
