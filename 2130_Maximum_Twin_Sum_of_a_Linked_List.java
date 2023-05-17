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
    public int pairSum(ListNode head) {
        int[] myInt = new int[10*10*10*10*10+1];
        int counter=0;
        ListNode curr = head;

        while(curr != null)
        {
            myInt[counter] = curr.val;
            counter++;
            curr = curr.next;
        }

        int max=0;
        for(int i = 0; i < counter/2; i++)
        {
            max = Math.max(max, myInt[i] + myInt[counter - 1 - i]);
        }

        return max;
    }
}
