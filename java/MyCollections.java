import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MyCollections {
    public static void main(String[] args) {
        //Array
        //initialize
        int[] testInput = new int[5];
        int[] testInput2 = {1, 2, 3, 4, 5};

        //insert
        for (int i = 0; i < testInput.length; i++) {
            testInput[i] = i;
        }

        //update value
        testInput2[1] = 99;

        //get value is O(1)
        int value = testInput2[1];

        System.out.println("value is  " + value);

        //print
        System.out.println("printing primitive array");
        for (int i = 0; i < testInput2.length; i++) {
            System.out.print(testInput2[i] + " ");
        }
        System.out.println();

        //ArrayList
        List<Integer> testList = new ArrayList<Integer>();

        //insert
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        //update value
        testList.set(1, 99);

        //get O(1)
        int valueList = testList.get(1);
        System.out.println("valueList is " + valueList);

        //deletion
        testList.remove(3);

        //print
        System.out.println("printing ArrayList");
        for (int i  : testList) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("printing ArrayList with iterator");
        Iterator<Integer> iter = testList.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        assert valueList == value;

        //LinkedList
        List<Integer> testLink = new LinkedList<Integer>();

        //insert
        testLink.add(1);
        testLink.add(2);
        testLink.add(3);
        testLink.add(4);
        testLink.add(5);

        //update value
        testLink.set(1, 99);

        //get O(n)
        int valueLink = testLink.get(1);

        System.out.println("valueLink is " + valueLink);

        //deletion
        testLink.remove(3);

        //print
        System.out.println("printing linkedlist ");
        Iterator<Integer> iter2 = testLink.iterator();

        while (iter2.hasNext()) {
            System.out.print(iter2.next() + " ");
        }
        System.out.println();

        assert valueList == valueLink;

        //tree set
        Set<Integer> treeSet = new TreeSet<>();

        //insert complexity : O(log n)
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        //duplicate insert
        treeSet.add(1);

        //remove complexity : O(log n)
        treeSet.remove(4);

        //print
        Iterator<Integer> iter3 = treeSet.iterator();

        System.out.println("printing treeset");
        while(iter3.hasNext()) {
            System.out.print(iter3.next() + " " );
        }
        System.out.println();

        if (treeSet.isEmpty()) {
            System.out.println("treeset is empty");
        } else {
            System.out.println("treeset is not empty");
        }

        //contains : complexity O(log n)
        if (treeSet.contains(5)) {
            System.out.println("tree set contains 5");
        } else {
            System.out.println("treeset doees not contains 5");
        }


        System.out.println();
    }
}
