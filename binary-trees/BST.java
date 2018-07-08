public class BST<E extends Comparable<? super E>> {

    private Node root;

    public BST() {
        root = null;
    }

    private class Node<E>{
        Node<E> left;
        Node<E> right;
        E value;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public E getData() {
            return this.value;
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
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

    public static void main(String[] args) {
        Integer[] arrFill = {1, 5, 2, 7, 4};
        BST<Integer> bst = new BST<Integer>();

        for (int i =0; i < arrFill.length; i++) {
            bst.put(arrFill[i]);
        }
    }
}
