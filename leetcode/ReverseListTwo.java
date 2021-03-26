/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode curr = head;

        ListNode leftPtr = null;
        ListNode rightPtr = null;
        Deque<Integer> myStack = new ArrayDeque<>();


        //iterate over the linked list
        // O(n)
        int count = 0;
        while (curr != null) {
            if (count == left - 1) {
                leftPtr = curr;

            }

            if (count == right - 1) {
                rightPtr = curr;
            }
            curr = curr.next;
            count++;
        }


        curr = leftPtr;
        while (curr != rightPtr) {

            myStack.push(curr.val);
            curr = curr.next;
        }


        if (rightPtr != null)
             myStack.push(rightPtr.val);


        curr = head;

        while (curr != null) {

            if (curr == leftPtr) {
                while (curr != rightPtr) {
                    curr.val = myStack.pop();
                    curr = curr.next;
                }

                if (curr != null)
                    curr.val = myStack.pop();
            }

            if (curr != null)
                curr = curr.next;
        }

        return head;

    }
}
