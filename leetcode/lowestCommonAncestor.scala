object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        
        if (root == null) root
        
        else if (root == p || root == q ) root
        
        else {
            val left = lowestCommonAncestor(root.left, p, q)
            val right = lowestCommonAncestor(root.right, p, q)
            
            if (left != null && right != null) root
            else if (left == null && right == null) null
            else if (left != null) left 
            else right
        }
   
    }
}