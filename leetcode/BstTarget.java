/*
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
import java.util.Set;
import java.util.HashSet;

class Node{
    int val;
    Node left;
    Node right;
    Node parent;

    public Node(int val) {
        this.val = val;
    }
}


public class BstTarget {
    private Node root;
    Set<Integer> storeDiff;

    public BstTarget() {
        storeDiff = new HashSet<>();
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    public Node insert(Node curr, int val) {

        if (curr == null) {
            return new Node(val);
        }

        if (val > curr.val) {
            curr.left =  insert(curr.right, val);
        } else {
            curr.right =  insert(curr.left, val);
        }

        return curr;

    }

    public boolean findTarget(Node curr, int target) {

        if (curr == null) {
            return false;
        }

        int rem = target - curr.val;

        if (! storeDiff.contains(curr.val)) {
            storeDiff.add(rem);
        } else {
            return true;
        }

        boolean leftTreeCheck = findTarget(curr.left, target);

        boolean rightTreeCheck = findTarget(curr.right, target);

        if (rightTreeCheck || leftTreeCheck) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        int[] testInput = {5, 3, 6, 2, 4, 7};
        BstTarget bst = new BstTarget();

        for (int i = 0; i < testInput.length; i++) {
            bst.insert(testInput[i]);
        }

        assert bst.findTarget(bst.root, 28) == false;
    }
}
