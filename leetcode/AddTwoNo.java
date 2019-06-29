class Node {
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
        next =null;
    }

}
/*
 * Add two linked list in reverse order
 */
public class  AddTwoNo{

    Node l1;
    Node l2;
    Node l3;

    /*
     * Inserts value into the linked list
     */
    public void insertl1(int val) {
        l1 = insert_value(val, l1);
    }

    public void insertl2(int val) {
        l2= insert_value(val, l2);
    }

    public Node getL1() {
        return l1;
    }

    public Node getL2() {
        return l2;
    }

    public Node getL3() {
        return l3;
    }

    public Node addTwoNo(Node l1, Node l2) {
        Node iter = null;
        l3 = iter;
        int rem = 0;

        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + rem ;
            int val = sum % 10;
            rem = sum / 10;
            l3 = insert_value(val, l3);
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + rem;
            int val = sum % 10;
            l3 = insert_value(val, l3);
            l1 = l1.next;
            rem = sum % 10;
        }

        while (l2 != null) {
            int sum = l2.val + rem;
            int val = sum %10;
            rem = sum / 10;
            l3 = insert_value(val, l3);
            l2 = l2.next;
        }

        if (rem > 0) {
            l3 = insert_value(rem, l3);
        }

        return l3;

    }

    public void dsp(Node iter) {
        while (iter != null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
    }

    public Node insert_value(int val, Node curr) {

        if (curr == null) {
            return new Node(val);
        }

        curr.next = insert_value(val, curr.next);

        return curr;
    }

    public static void main(String[] args) {

        //declare two primite integer array
        int[] l1_array = {2, 4, 3};
        int[] l2_array = {5, 6, 4};

        AddTwoNo objAdd = new AddTwoNo();

        //insert values into linked list
        for (int i = 0; i < l1_array.length; i++) {
            objAdd.insertl1(l1_array[i]);
        }


        //insert values into linked list
        for (int i = 0; i < l2_array.length; i++) {
            objAdd.insertl2(l2_array[i]);
        }

        objAdd.addTwoNo(objAdd.getL1(), objAdd.getL2());

        objAdd.dsp(objAdd.getL3());
    }
}
