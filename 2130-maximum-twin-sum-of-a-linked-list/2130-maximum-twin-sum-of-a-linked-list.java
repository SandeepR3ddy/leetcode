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
    
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode curr=  head, prev = null, next = null;
        
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        return prev;
    }
    public ListNode midNode(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    
    public int pairSum(ListNode head) {
        
        ListNode mid = midNode(head);
        
        ListNode newHead = reverse(mid.next);
        
        mid.next = null;
        
        int ans = Integer.MIN_VALUE;
        
        while(head != null)
        {
            ans = Math.max(ans, head.val+ newHead.val);
            head = head.next;
            newHead = newHead.next;
        }
        
        return ans;
    }
}