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
    
    private ListNode addFirst(ListNode node,ListNode thead)
    {
        if(thead == null)
        {
            thead = node;
        }
        else
        {
            node.next = thead;
            thead = node;
        }
        
        return thead;
    }
    
    public ListNode reverseList(ListNode head) {
       
        ListNode curr = head;
        
        ListNode thead = null;
        
        while(curr != null)
        {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = null;
            
            thead = addFirst(temp,thead);
        }
        return thead;
    }
}