/**
 * Implementing Maximum Heap
 */
public class MaximumPQ <T extends Comparable<T>>
{
    //data field
    private T[] pq;
    private int N;

    public MaximumPQ(int capacity) {
        pq = (T[]) new Comparable[capacity + 1 ];
        N = 0;
    }

    public MaximumPQ() {
        this(1);
    }

    public void resize(int capacity) {
        T[] temp = (T[]) new Comparable[capacity + 1];

        for (int i = 0; i <= N; i++) {
            temp[i] = pq[i];
        }

        pq = temp;
    }

    public void insert(T value) {
        //resize
        if ( N == pq.length - 1)  {
            resize(pq.length * 2);
        }

        pq[++N] = value;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private boolean less(int i, int j) {
        return  pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i , int j) {
        T  temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public T deleteMax() {
        T max = pq[1];
        exchange(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private void sink(int k) {
        while(2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j+1)){
                j++;
            }
            if (!less(k, j)) break;
            exchange(j, k);
            k = j;
        }
    }

    public void printPQ() {
        for (int i = 1 ; i <= N; i++) {
            System.out.print(pq[i] + " " );
        }
    }

    public static void main(String[] args) {
        MaximumPQ<Integer> mpq = new MaximumPQ<>();

        int[] testInput = {20, 5, 10, 70, 3, 9, 15};
        for (int i = 0; i < testInput.length; i++) {
            mpq.insert(testInput[i]);
        }

        mpq.printPQ();

        System.out.println();

        mpq.deleteMax();

        mpq.printPQ();


        MaximumPQ<Character> mq = new MaximumPQ<>();

        String testString = "TSRPNOAEIHG";

        for (char ch : testString.toCharArray()) {
            mq.insert(ch);
        }

        //mq.printPQ();

    }
}
