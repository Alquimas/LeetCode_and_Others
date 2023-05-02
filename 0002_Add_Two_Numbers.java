/*
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int x = 0;
        ListNode ls = new ListNode();
        ListNode ls2 = new ListNode();
        ListNode ls3 = new ListNode();
        ListNode retorno = new ListNode();

        ls = l1;
        ls2 = l2;
        ls3 = retorno;
        while(ls != null || ls2 != null)
        {
            if(ls != null)
            {
                x = x+ls.val;
                ls = ls.next;
            }
            if(ls2 != null)
            {
                x = x+ls2.val;
                ls2 = ls2.next;
            }
            ls3.val = x%10;
            x = (x >= 10) ? 1 : 0;
            if(ls != null || ls2 != null)
            {
                ls3.next = new ListNode();
                ls3 = ls3.next;
            }
        }
        if(x > 0)
        {
            ls3.next = new ListNode();
            ls3 = ls3.next;
            ls3.val = x; 
        }
        return retorno;
    }
}
