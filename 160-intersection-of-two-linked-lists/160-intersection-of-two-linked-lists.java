/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int length(ListNode head)
    {
        int count = 0;
        
        while(head != null)
        {
             head = head.next;
            count++;
        }
        
        return count;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
        int l1 = length(headA);
        int l2 = length(headB);
        
        ListNode c1 = headA, c2 = headB;
        
        int diff = Math.abs(l1-l2);
        
        if(l1 > l2)
        {
            while(diff-- > 0)
            {
                c1 = c1.next;
            }
        }
        else
        {
           while(diff-- > 0)
            {
                c2 = c2.next;
            }            
        }
        
        while(c1 != c2)
        {
            c1 = c1.next;
            c2 = c2.next;

        }
        return c1;
    }
    
}