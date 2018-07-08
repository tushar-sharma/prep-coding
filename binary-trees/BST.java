import java.util.Queue;
import java.util.LinkedList;

/**
 * Implement binary search tree
 */
public class BST<E extends Comparable<? super E>> {

    private Node root;

    public BST() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    private class Node<E>{

        private Node<E> left;
        private Node<E> right;
        private E value;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public E getData() {
            return value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    public void put(E toInsert) {
        root = put(toInsert, root);
    }

    public Node<E> put(E toInsert, Node<E> curr) {

         if (curr == null) {
             return new Node(toInsert);
         }

         int comp = toInsert.compareTo(curr.getData());

         if (comp < 0) {
             curr.setLeft(put(toInsert, curr.getLeft()));
         } else if (comp > 0) {
            curr.setRight(put(toInsert, curr.getRight()));
         }
         return curr;
    }

    public boolean contains(E toFind) {
        Node<E> curr = root; int comp;

        while (curr != null)  {
            comp = toFind.compareTo(curr.getData());

            if (comp < 0) {
                curr = curr.getLeft();
            } else if (comp > 0) {
                curr = curr.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    public void levelorder() {
        Queue<E> keys = new LinkedList<E>();
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> curr = queue.poll();

            if (curr == null) continue;

            keys.add(curr.getData());
            queue.add(curr.getLeft());
            queue.add(curr.getRight());
        }

        for (E s : keys) {
            System.out.print(s.toString() + " ");
        }
        System.out.println();
    }

    public Node<E> inorder(Node<E> curr) {

        if (curr == null) {
            return null;
        }

        inorder(curr.getLeft());

        System.out.print(curr.getData() + " ");

        inorder(curr.getRight());

        return curr;
    }

    public Node<E> preorder(Node<E> curr) {
        if (curr == null) {
            return null;
        }

        System.out.print(curr.getData() + " ");

        preorder(curr.getLeft());
        preorder(curr.getRight());
        return curr;
    }

    public Node<E> postorder(Node<E> curr) {
        if (curr == null) {
            return null;
        }


        postorder(curr.getLeft());
        postorder(curr.getRight());

        System.out.print(curr.getData() + " ");

        return curr;
    }

    public static void main(String[] args) {
        String[] arrFill = {"1", "5", "2", "7", "4"};
        BST<String> bst = new BST<String>();

        for (int i =0; i < arrFill.length; i++) {
            bst.put(arrFill[i]);
        }

        System.out.println("\nLevel order traversal");
        bst.levelorder();
        System.out.println("\nIn order traversal");
        bst.inorder(bst.root);
        System.out.println("\nPre order traversal");
        bst.preorder(bst.root);
        System.out.println("\npost order traversal");
        bst.postorder(bst.root);
    }
}
