/**
 * implement a generic stack
 */
public class StackGen<Item> {

    private class Node<Item> {
        Node next;
        Item item;
    }

    private Node head = null;

    void push(String item) {
        Node oldhead = head;
        head = new Node();
        head.item = item;
        head.next = oldhead;
    }

    void view() {
        Node it = head;

        while (it != null) {
            System.out.println(it.item);
            it = it.next;
        }
    }

    public static void main(String[] args) {

        String[] inputStr = {"back", "me", "read"};

        StackGen<String> sg = new StackGen<>();

        for (String it : inputStr) {
            sg.push(it);
        }

        sg.view();

    }
}
