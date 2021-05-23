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
    
    public static void buildParentMap(TreeNode curr, Map<TreeNode, TreeNode> parent) {
        
           if (curr == null){
               return;
           }
        
           if (curr.left != null) {
               parent.put(curr.left, curr);
           }
        
           if (curr.right != null) {
               parent.put(curr.right, curr);
           }
        
           buildParentMap(curr.left, parent);
        
           buildParentMap(curr.right, parent);   
        
    }
    
    public static void findNodes(TreeNode target,
                                 int k,
                                 int accumulator,
                                 Map<TreeNode, TreeNode> parent,
                                 List<Integer> result,
                                 Set<TreeNode> visited){
        
        if (target == null || accumulator > k) {
            return;
        }
        
        if (k == accumulator){
            result.add(target.val);
        }
        
        visited.add(target);
        
        if (!visited.contains(target.left)) {
            findNodes(target.left,
                  k,
                 accumulator + 1,
                 parent,
                 result,
                 visited);
            
        }
        

        if (!visited.contains(target.right)) {

            findNodes(target.right,
                  k,
                  accumulator + 1,
                 parent,
                 result,
                 visited);
        }
        
        if (!visited.contains(parent.get(target))) {

            findNodes(parent.get(target),
                   k,
                   accumulator + 1,
                   parent,
                  result,
                  visited);   
        }
                 
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        List<Integer> result = new ArrayList<>();
        
        buildParentMap(root, parent);
        
        Set<TreeNode> visited = new HashSet<>();
        
        findNodes(target,
                  k,
                  0,
                  parent,
                  result,
                  visited);
        
        return result;
        
    }
}
