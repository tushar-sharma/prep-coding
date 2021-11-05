class Node {
    TreeNode next;
    int depth;
    
    public Node(TreeNode next, int depth) {
        this.next = next;
        this.depth = depth;
    }
}
class Solution {
    Queue<Node> queue = new LinkedList<>(); 
    int maximum = Integer.MIN_VALUE;
    
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            
            Node node = new Node(root, 1);
            
            queue.add(node);
            
            while (!queue.isEmpty()) {
                
                Node current = queue.poll();
                
                if (current.next.left != null) {
                    node = new Node(current.next.left, current.depth + 1);
                    queue.add(node);
                }
                
                if (current.next.right != null) { 
                    node = new Node(current.next.right, current.depth + 1);
                    queue.add(node);
                }
                
                
                if ((current.next.left == null) &&  (current.next.right == null)) { 
                    if (maximum < current.depth) {
                        maximum = current.depth;
                    }
                    
                }
            }
            
            
            return maximum;
            
        }
        
    }
}
