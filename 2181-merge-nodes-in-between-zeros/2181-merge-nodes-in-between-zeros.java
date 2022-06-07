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
    public ListNode mergeNodes(ListNode head) {
     
      ListNode curr = head.next;
        
        ListNode nextNode = curr.next;
        
        while(curr != null)
        {
            if(nextNode.val != 0)
            {
                curr.val += nextNode.val;
                nextNode = nextNode.next;
            }
            else
            {
                curr.next = nextNode.next;
                
                curr = curr.next;
                
                if(curr != null)
                {
                    nextNode = curr.next;
                }
            }
        }
        return head.next;
    }
}