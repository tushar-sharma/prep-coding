import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

/*
 * Find k longest string
 */
public class KthLargest {

    public String topK(int k, Iterator<String> iter) {

        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        while(iter.hasNext()) {
            minHeap.add(iter.next());
        }

        String kvalue = null;

        while (k-- > 0) {
            kvalue = minHeap.poll();
        }

        return  kvalue;

    }

    public static void main(String[] args) {

        KthLargest kth = new KthLargest();

        List<String> lst = new ArrayList<>();
        lst.add("hello");
        lst.add("bla");
        lst.add("superman");
        lst.add("to");

        System.out.println(lst);

        int k = 3;

        System.out.println(kth.topK(k, lst.iterator()));

    }
}
