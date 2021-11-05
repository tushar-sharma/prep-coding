var lowestCommonAncestor = function(root, p, q) {
    
    if (root == null) {
        return null;
    }

    let left = root;
    let right = root; 
    let parent = null; 
    
    while (left != null && right != null) {
        if (left == right) {
            parent = left;
        }
        
        if (left == p && right == q ) {
             break;
        }
        
        if (p.val < left.val) {
            left = left.left;
        } else if (p.val > left.val) {
            left = left.right;
        }
        
        if (q.val < right.val) {
            right = right.left;
        } else if (q.val > right.val) {
            right = right.right;
        }
    }
    return parent;    
    
};
