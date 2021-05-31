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

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();

        List<List<Integer>> output = new ArrayList<>();

        Map<TreeNode, List<Integer>> trackLimit = new HashMap<>();

        if (root == null){
            return output;
        }

        queue.offer(root);
        trackLimit.put(root, Arrays.asList(root.val));

        int limit =1;

        while(!queue.isEmpty()){


            int curLimit = limit;
            limit = 0;
            List<Integer> tempOutput = new ArrayList<>();

            while(curLimit-- > 0) {

                TreeNode curr = queue.poll();

                tempOutput.add(curr.val);

                if (curr.left != null){
                    queue.offer(curr.left);
                    limit++;
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                    limit++;
                }


            }
            output.add(tempOutput);

        }

        return output;

    }
}
