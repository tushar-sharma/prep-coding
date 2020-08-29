/**
 * Implement binary Search Tree
 * following operations
 * insert element
 * search
 */
class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    Node<T> parent;

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    //insert data into a new node
    public void insert(T data) {
        root = insert(data, root);
    }

    public Node<T> insert(T data, Node<T> curr) {
        if (curr == null) {
            return new Node(data, curr);
        }

        int comp = data.compareTo(curr.getData());

        if (comp < 0) {
            curr.setLeft(insert(data, curr.getLeft()));
        } else if (comp > 0) {
            curr.setRight(insert(data, curr.getRight()));
        }

        return curr;

    }

    public boolean preorder(Node<T> curr) {

        if (curr == null) {
            return false;
        }

        System.out.print(curr.getData() + " " );
        preorder(curr.getLeft());
        preorder(curr.getRight());

        return  true;
    }

    public static void main(String[] args) {
        String[] arrFill = {"50", "15", "72", "49", "73"};

        BinarySearchTree<String> bst = new BinarySearchTree<>();

        for (String st : arrFill) {
            bst.insert(st);
        }

        bst.preorder(bst.root);
        System.out.println();
    }
}
