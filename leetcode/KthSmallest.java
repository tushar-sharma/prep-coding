class Solution {
    
    private int count = 0;
    private int ksmallest = 0;
    
    public TreeNode inorder(TreeNode curr, int k ) {
        if (curr == null) {
            return null;
        }
        
        inorder(curr.left, k);
        
        if (count++ == (k - 1) ) {
            ksmallest = curr.val;
        }
        
        inorder(curr.right, k ); 
        
        return curr;
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        
        return ksmallest;
        
    }
}
