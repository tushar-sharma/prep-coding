class Solution {
    
    private TreeNode lca; 
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return null; 
        }
      
        TreeNode left = root; 
        TreeNode right = root;     
        
        
        while (left != null && right != null) {
            
            if (left == right ) 
                lca = left; 
            
            if (left == p && right == q) {
                break;
            }
            
            if (p.val < left.val) {
                left = left.left ;
            } else if (p.val > left.val ) {
                left = left.right; 
            } 
            
            if (q.val < right.val) {
                right = right.left;
            } else if (q.val > right.val) {
                right = right.right; 
            }

        }
        
        return lca; 
    }
}
