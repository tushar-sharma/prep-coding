/*
 * Problem: Add two linked list in reverse order
 * See: addTwoNumbers
 * url: https://leetcode.com/problems/add-two-numbers/
 */
class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
        next =null;
    }
}

public class  AddTwoNo{

    ListNode series1 = null;
    ListNode series2 = null;

    public ListNode addTwoNumbers(ListNode series1, ListNode series2) {
        ListNode series3 = null;
        int rem = 0, sum = 0;

        while (series1 != null || series2 != null) {
            sum = 0;

            if (series1 != null){
                sum = series1.val;
                series1 = series1.next;
            }

            if (series2 != null) {
                sum += series2.val;
                series2 = series2.next;
            }

            sum += rem;
            rem = sum / 10;

            series3 = insertSeriesValue(series3, sum % 10);
        }

        if (rem > 0)  {
            series3 = insertSeriesValue(series3, rem);
        }

        return series3;
    }

    public ListNode insertSeries(ListNode series, int value) {
        return insertSeriesValue(series, value);
    }

    public ListNode insertSeriesValue(ListNode curr, int value) {
        if (curr == null) {
            return new ListNode(value);
        }

        curr.next = insertSeriesValue(curr.next, value);

        return curr;
    }

    public ListNode getSeries1() {
        return series1;
    }

    public void setSeries1(ListNode series) {
        this.series1 = series;
    }

    public void setSeries2(ListNode series) {
        this.series2 = series;
    }

    public ListNode getSeries2() {
        return series2;
    }


    public void display(ListNode iter) {
        while(iter != null) {
            System.out.print(iter.val);
            System.out.print(" ");
            iter = iter.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // insert values for linkedlists
        int[] inputSeries1 = new int[]{2, 4, 3};
        int[] inputSeries2 = new int[]{5, 6, 4};

        AddTwoNo addTwoNo = new AddTwoNo();

        for (int i = 0; i < inputSeries1.length; i++) {
            addTwoNo.setSeries1(addTwoNo.insertSeries(addTwoNo.getSeries1(),
                                  inputSeries1[i]));
        }

        for (int i = 0; i < inputSeries2.length; i++) {
            addTwoNo.setSeries2(addTwoNo.insertSeries(addTwoNo.getSeries2(),
                                  inputSeries2[i]));
        }

        //addTwoNo.display(addTwoNo.getSeries2());
    }
}
