/**
 * Implement Binary Search Tree 
 * */
class Node<T>{
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
}

class BST <T extends Comparable<T>>{

    Node<T> root = null;

    public void insert(T value) {
        root = insert(value, root);
    }

    public void preorder(Node<T> curr) {

        if (curr == null) 
            return;

        System.out.print(curr.getValue() + " " );

        preorder(curr.getLeft());

        preorder(curr.getRight());
    }

    public void search(Node<T> curr, T toSearch)  {
        if (curr == null) {
            System.out.println(toSearch + " is NOT in the tree");
            return;
        }

        int compare = curr.value.compareTo(toSearch);

        if (compare == 0) {
            System.out.println(toSearch + " is in the tree");
            return;
        } else if (compare > 0) {
            search(curr.getLeft(), toSearch);
        } else {
            search(curr.getRight(), toSearch);
        }
    }

    public Node<T> insert(T value, Node<T> curr) {
        if (curr == null) {
            curr = new Node(value);
        }

        int compare = value.compareTo(curr.getValue());

        if (compare > 0 ){
            curr.setRight(insert(value, curr.getRight()));
        } else if (compare < 0)  {
            curr.setLeft(insert(value, curr.getLeft()));
        }

        return curr;

    }

    public static void main(String[] args) {

        int[] bstInput = {8, 10, 3, 6, 1, 4, 7, 14, 13};

        BST<Integer> bst = new BST<>();

        for (int i = 0; i < bstInput.length; i++) {
            bst.insert(bstInput[i]);
        }

        System.out.println("Preorder traversal is ");

        bst.preorder(bst.root);

        int toSearch = 100;

        System.out.println("Finding " + toSearch + " in the tree");

        bst.search(bst.root, toSearch);

    }
}
