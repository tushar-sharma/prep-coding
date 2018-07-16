import java.util.ArrayList;

public class MinHeap {

    private  static ArrayList<Integer> queue = null;

    public static void heapifyUp(int child) {

        int parent = (child  - 1) / 2;

        if(child != 0 && queue.get(parent) > queue.get(child)) {

            //swap
            int swap = queue.get(parent);
            queue.set(parent, queue.get(child));
            queue.set(child, swap);

            heapifyUp(parent);
        }
    }

    /**
     */
    public static void heapifyDown(int parent) {

        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int left_value, right_value, parent_value, small_value, small;


        if (left >= queue.size() ) {
            left_value = Integer.MAX_VALUE;
        } else {
            left_value = queue.get(left);
        }

        if (right >= queue.size() ) {
            right_value = Integer.MAX_VALUE;
        } else {
            right_value = queue.get(right);
        }

        parent_value = queue.get(parent);
        //System.out.println("parent is "+ parent_value);

        if (parent_value > left_value || parent_value > right_value) {

            if (left_value < right_value) {
                small = left;
                small_value = left_value;
            } else {
                small = right;
                small_value = right_value;
            }

            //System.out.println("small is " + small_value);

            int swap = parent_value;
            queue.set(parent, small_value);
            queue.set(small, parent_value);

            heapifyDown(small);
        }
    }

    /**
     * @return minimum integer
     */

    public static int extractMin() {
        if (queue.size() == 0) {
            return -1;
        }
        int minimum = queue.get(0);

        // set the last element as root
        int last = queue.get(queue.size() - 1);
        queue.set(0, last);
        //remove last element
        queue.remove(queue.size() - 1);
        heapifyDown(0);

        return minimum;
    }


    /**
     * add a integer to a heap
     * @param toInsert - value to be inserted int hte ArrayList
     * @return nill
     */
    public static void insert(int toInsert) {
        //add to the last
        queue.add(toInsert);

        heapifyUp(queue.size()  - 1);
    }

    /**
     */
    public static void display() {

        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i) + " " );
        }
        System.out.println();

    }

    public static void main(String[] args) {

        int[] testInput = {4, 4, 8, 9, 4, 12, 9, 11, 13 , 7, 10, 5};

        queue = new ArrayList<Integer>();

        for (int i = 0; i < testInput.length; i++) {
            insert(testInput[i]);
        }

        display();

        System.out.println("Minimum is " + extractMin());

        display();

    }
}
