import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/*
 * Insert the following nodes into an initally empty min heap : 12,5,15,9,13,7,15,10,3,20,4.
 *  design min heap from scratch
 */
public class Ex3 <T extends Comparable<T>> {

    private T[] pq ;
    private int n = 0;

    public Ex3(int capacity) {
        pq = (T[]) new Comparable[capacity];
        n = 0;
    }

    public Ex3() {
        this(1);
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Comparable[capacity];

        for (int i = 0; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void getPQ() {
        for(int i = 1; i <= n ; i++) {
            System.out.print(pq[i] + " ," );
        }
    }

    private boolean less(int x, int y) {
        return pq[x].compareTo(pq[y]) < 0;
    }

    private void exchange(int x, int y) {
        T temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    public void heapifyUp(int k) {
        //while we are at not root and parent is more than children
        while (k > 1 && less(k, k/2)) {
            exchange(k, k/2);
            k = k / 2;
        }
    }

    public void heapifyDown(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            //pick the smaller one
            if (j < n && less(j+1, j)) j++;

            if (less(k, j)) break;

            exchange(k, j);
            k = j;
        }
    }


    public void insert(T value) {

        //resize
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = value;

        heapifyUp(n);

    }

    public T deleteMin() {
        T min = pq[1];
        exchange(1, n--);
        heapifyDown(1);
        pq[n + 1] = null;
        return min;

    }

    public static void main(String[] args) {

        Ex3<Integer> ex3 = new Ex3<>();

        List<Integer> testInput = new ArrayList<>();

        testInput.add(12);
        testInput.add(5);
        testInput.add(15);
        testInput.add(9);
        testInput.add(13);
        testInput.add(7);
        testInput.add(15);
        testInput.add(10);
        testInput.add(3);
        testInput.add(20);
        testInput.add(4);

        Iterator<Integer> iter = testInput.iterator();

        while (iter.hasNext()) {
            ex3.insert(iter.next());
        }

        ex3.getPQ();

        System.out.println(ex3.deleteMin());

        ex3.getPQ();



    }
}
