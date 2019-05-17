
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

    public Node<T> getRigth() {
        return right;
    }
}

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    //insert data into a new node
    public boolean insert(T data) {
        Node<T> curr = root;
        int comp = data.compareTo(curr.getData());

        while (comp < 0 && curr.getLeft() != null) {
            if (comp < 0) {
                curr = curr.getLeft();
            } else if (comp > 0) {
                curr = curr.getRight();
            } else {
                return false;
            }
        }

        curr = new Node<T>(data, curr);
        return true;
    }

    public static void main(String[] args) {
        String[] arrFill = {"1", "5", "2", "7", "4"};

        BinarySearchTree<String> bst = new BinarySearchTree<>();

        for (String st : arrFill) {
            bst.insert(st);
        }
    }
}
