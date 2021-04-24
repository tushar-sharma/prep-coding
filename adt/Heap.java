/**
 * Min Heap & Max Heap
 */

class MaxHeap <T extends Comparable<T>>{

    private T[] pq;

    private int n;

    public MaxHeap(int size) {
        pq = (T[]) new Comparable[size];
        n = 0;

    }

    public MaxHeap() {
        this(1);
    }

    public void insert(T value) {

        if (n == pq.length - 1) {
            resize( 2 * pq.length);
        }

        pq[++n] = value;

        heapifyUp(n);
    }

    public T max() {
        return pq[1];
    }

    public T extractMax() {

        T min = pq[1];

        exchange(1, n--);

        heapifyDown(1);

        pq[n + 1] = null;

        return min;
    }

    public boolean more(int x, int y) {
        return pq[x].compareTo(pq[y]) > 0;
    }

    public void exchange(int x, int y) {
        T temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    public void heapifyUp(int k) {

        while (k > 1 && more(k, k/2)) {
            exchange(k , k/2);
            k = k/2;
        }
    }

    public void heapifyDown(int k) {

        while (2 * k <= n) {

            int j = 2 * k;

            if (j < n && more(j + 1, j)) j++;

            if (more(k, j)) break;

            exchange(k, j);

            k = j;
        }
    }

    public void resize(int size) {
        T[] temp  = (T[]) new Comparable[size];

        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }

        pq = temp;
    }

    public void dsp() {

        for(int i = 1; i <= n; i++) {
            System.out.print(pq[i] + " ");
        }

        System.out.println();
    }

}


class MinHeap <T extends Comparable<T>>{

    private T[] pq;

    private int n;

    public MinHeap(int size) {
        pq = (T[]) new Comparable[size];
        n = 0;

    }

    public MinHeap() {
        this(1);
    }

    public void insert(T value) {

        if (n == pq.length - 1) {
            resize( 2 * pq.length);
        }

        pq[++n] = value;

        heapifyUp(n);
    }

    public T min() {
        return pq[1];
    }

    public T extractMin() {

        T min = pq[1];

        exchange(1, n--);

        heapifyDown(1);

        pq[n + 1] = null;

        return min;
    }

    public boolean less(int x, int y) {
        return pq[x].compareTo(pq[y]) < 0;
    }

    public void exchange(int x, int y) {
        T temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    public void heapifyUp(int k) {

        while (k > 1 && less(k, k/2)) {
            exchange(k , k/2);
            k = k/2;
        }
    }

    public void heapifyDown(int k) {

        while (2 * k <= n) {

            int j = 2 * k;

            if (j < n && less(j + 1, j)) j++;

            if (less(k, j)) break;

            exchange(k, j);

            k = j;
        }
    }

    public void resize(int size) {
        T[] temp  = (T[]) new Comparable[size];

        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }

        pq = temp;
    }

    public void dsp() {

        for(int i = 1; i <= n; i++) {
            System.out.print(pq[i] + " ");
        }

        System.out.println();
    }

}

class Heap {

    public static void main(String[] args) {

        int[] inputArray = {3, 7, 9, 8, 5, 6, 1};

        MinHeap minHeap = new MinHeap();

        for (int i = 0; i < inputArray.length; i++){
            minHeap.insert(inputArray[i]);
        }

        minHeap.dsp();

        System.out.println("Min element is "  + minHeap.min());

        System.out.println("extract Min element is "  + minHeap.extractMin());

        minHeap.dsp();

        System.out.println("extract Min element is "  + minHeap.extractMin());

        minHeap.dsp();

        //max heap
        MaxHeap maxHeap = new MaxHeap();

        for (int i = 0; i < inputArray.length; i++){
            maxHeap.insert(inputArray[i]);
        }

        maxHeap.dsp();

        System.out.println("Max element is "  + maxHeap.max());

        System.out.println("extract Max element is "  + maxHeap.extractMax());

        maxHeap.dsp();

        System.out.println("extract Max element is "  + maxHeap.extractMax());

        maxHeap.dsp();

    }
}
