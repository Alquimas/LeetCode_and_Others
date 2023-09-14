/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    static int t = 1000001;
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        while(head.next != null)
        {
            if(head.val == t)
            {
                return true;
            }
            else
            {
                head.val = t;
                head = head.next;
            }
        }
        return false;
    }
}
