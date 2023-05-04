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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list1 == null && list2 == null) return list1;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode myList = new ListNode();
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode pointer3 = myList;

        while(pointer1 != null || pointer2 != null)
        {
            if(pointer1 == null)
            {
                pointer3.val = pointer2.val;
                pointer2 = pointer2.next;
                if(pointer1 != null || pointer2 != null)
                {
                    pointer3.next = new ListNode();
                    pointer3 = pointer3.next;
                }
                continue;
            }
            if(pointer2 == null)
            {
                pointer3.val = pointer1.val;
                pointer1 = pointer1.next;
                if(pointer1 != null || pointer2 != null)
                {
                    pointer3.next = new ListNode();
                    pointer3 = pointer3.next;
                }
                continue;
            }

            if(pointer1.val < pointer2.val)
            {
                pointer3.val = pointer1.val;
                pointer1 = pointer1.next;
                if(pointer1 != null || pointer2 != null)
                {
                    pointer3.next = new ListNode();
                    pointer3 = pointer3.next;
                }
            }
            else
            {
                pointer3.val = pointer2.val;
                pointer2 = pointer2.next;
                if(pointer1 != null || pointer2 != null)
                {
                    pointer3.next = new ListNode();
                    pointer3 = pointer3.next;
                }
            }
        }

        return myList;
    }
}
