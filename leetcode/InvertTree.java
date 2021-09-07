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
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null){
            return null;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            
            
            if (curr != null){
                TreeNode tempValue = curr.left;
                curr.left = curr.right;
                curr.right = tempValue;
            }
            
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            
            if (curr.right != null) {
                queue.offer(curr.right);
            }

        }
        
        
        
        return root;
        
    }
}
