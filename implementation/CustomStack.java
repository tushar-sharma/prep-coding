/*
 * Implementation of stack
 * push(x) to insert x into stack
 * pop() to return top most element
 * peek() to print top most element
 * isEmpty to check if stack is empty or not
 * size() to print the size of the stack
 * */

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class CustomStack{

    Node head = null;
    int stack_size = 0;

    public void push(int value) {

        Node node = new Node(value);

        node.next = head;

        head = node;

        stack_size++;
    }

    public int pop() {

        if (stack_size > 0) {

            int value = head.value;

            head = head.next;
            return value;

        } else {
            return -1;
        }
    }

    public int peek() {
        if (head != null) {
            return head.value;
        } else{
            return -1;
        }
    }


    public int size() {
        return stack_size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();

        assert stack.isEmpty() == true;

        stack.push(4);

        stack.push(3);

        assert stack.peek() == 3;

        assert stack.size() == 2;

        stack.push(2);

        assert stack.pop() == 2;

        assert stack.pop() == 3;

        assert stack.pop() == 4;

    }
}
