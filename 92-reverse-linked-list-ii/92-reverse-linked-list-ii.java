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
    
    ListNode thead = null;
    ListNode ttail = null;
    
    public void addFirst(ListNode node)
    {
        
        if(thead == null)
        {
            thead = ttail = node;
        }
        else 
        {
            node.next = thead;
            thead = node;
        }
        
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode curr = head, prev = null;
        
        int idx = 1;
        
        while(curr != null)
        {
            while(curr != null && idx >= left && idx <= right)
            {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
                idx++;
            }
            
            if(idx > right)
            {
               if(prev != null)
               {
                   prev.next = thead;
                   ttail.next = curr;
               }
               else
               {
                   head = thead;
                   ttail.next = curr;
               }
                return head;
            }
            
            idx++;
            if(curr != null)
            {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}