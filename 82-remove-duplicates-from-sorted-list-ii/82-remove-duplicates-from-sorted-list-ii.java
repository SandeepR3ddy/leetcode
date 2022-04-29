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
    public ListNode deleteDuplicates(ListNode head) {
     if(head == null || head.next == null)
      {
          return head;
      }
      
      ListNode dummy = new ListNode(-1), prev = dummy, curr = head.next;
      prev.next = head;  
      
        while(curr != null)
      {
        
      
      boolean isSequence = false;
        
        while(curr != null && prev.next.val == curr.val)
        {
            isSequence = true;
            curr = curr.next;
        }
        if(isSequence)
        {
            prev.next = curr;
        }
        else
        {
            prev = prev.next;
        }
          
        if(curr != null)
        {
            curr = curr.next;
        } 
      }
        ListNode newHead = dummy.next;
        dummy.next = null;
      return newHead;
    }
}