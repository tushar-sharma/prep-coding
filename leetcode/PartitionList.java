/**
 * url: https://leetcode.com/problems/partition-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode lessHead = new ListNode(0);
        ListNode equalHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode lessIter = lessHead;
        ListNode equalIter = equalHead;
        ListNode greaterIter = greaterHead;

        ListNode iter = head;

        while (iter != null) {

            if (iter.val < x) {
                lessIter.next = iter;
                lessIter = iter;
            } else {
                greaterIter.next = iter;
                greaterIter = iter;
            }
            iter = iter.next;
        }

        greaterIter.next = null;
        lessIter.next =  greaterHead.next;

        return lessHead.next;

    }
}
