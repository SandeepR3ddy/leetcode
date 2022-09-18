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
    
    public int count(ListNode curr)
    {
        int count = 0;
        while(curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
        ListNode ghead = null, gtail = null, curr = head;
        
        int n = count(head);
        
        while(k <= n)
        {
            int temp = k;
            
            while(temp-- > 0)
            {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            
            if(ghead == null)
            {
                ghead = thead;
                gtail = ttail;
            }
            else
            {
                gtail.next = thead;
                gtail = ttail;
            }
            
            thead = ttail = null;
        
             n -= k;
            
        }
        
        gtail.next = curr;
        
        return ghead;
    }
}