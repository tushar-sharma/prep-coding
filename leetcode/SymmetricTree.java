class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        return checkSymmetric(root.left, root.right);
        
    }
    
    public boolean checkSymmetric(TreeNode subtree1, TreeNode subtree2) {
        
        if (subtree1 == null && subtree2 == null) {
            return true;
        } 
        
        else  if (subtree1 != null && subtree2 != null) {
            
            return subtree1.val == subtree2.val && 
                checkSymmetric(subtree1.left, subtree2.right) && checkSymmetric(subtree1.right, subtree2.left);
        } 
        
        return false;
    }
}
