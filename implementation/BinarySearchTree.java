/** 
  * Implement binary search tree
  * Supports : Insertion
  *            Preorder traversal
  */  
class Node<T> {
    T value;

    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}

public class BinarySearchTree <T extends Comparable<T>> {

    Node<T> root = null;

    public void insert(T value) {
        root = insert(value, root);
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    public void preorder(Node<T> curr) {
        if (curr == null) {
            return;
        }

        System.out.print(curr.getValue() + " ");

        preorder(curr.getLeft());
        preorder(curr.getRight());
    }

    public Node<T> insert(T value, Node<T> curr) {

        if (curr == null) {
            curr = new Node(value);
        }

        int cmp = curr.getValue().compareTo(value);

        if (cmp > 0 ) {
            curr.setLeft(insert(value, curr.getLeft()));
        } else if (cmp < 0 ) {
            curr.setRight(insert(value, curr.getRight()));
        }

        return curr;

    }

    public static void main(String[] args) {

        int[] insertTree = {50, 15, 72, 49, 73};

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int i = 0; i < insertTree.length; i++) {
            bst.insert(insertTree[i]);
        }

        bst.preorder();
    }
}
