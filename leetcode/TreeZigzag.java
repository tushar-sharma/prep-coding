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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }


        Deque<Integer> stack = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();


        queue.offer(root);

        boolean isZigZag = false;

        int limit = 1;
        TreeNode curr;

        while (!queue.isEmpty()) {

            int currLimit = limit;
            limit = 0;

            List<Integer> tempOutput = new ArrayList<>();

            while (currLimit-- > 0) {
                curr = queue.poll();

                if (!isZigZag)

                    tempOutput.add(curr.val);
                else
                    stack.push(curr.val);

                if (curr.left != null)  {
                    limit++;

                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    limit++;
                    queue.offer(curr.right);

                }
            }

            while (!stack.isEmpty()) {
                tempOutput.add(stack.pop());
            }

            output.add(tempOutput);

            isZigZag = !isZigZag;

        }
        return output;
    }
}
