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
    
    public ListNode merge(ListNode l1, ListNode l2)
    {
        
        ListNode dummy = new ListNode(-1);
        
        ListNode prev = dummy, c1 = l1, c2 = l2;
        
        while(c1 != null && c2 != null)
        {
            
            if(c1.val <= c2.val)
            {
                prev.next = c1;
                c1 = c1.next;
            }
            else
            {
                prev.next = c2;
                c2 = c2.next;
            }
            
            prev = prev.next;    
        }
        
        if(c1 != null)
        {
            prev.next = c1;
        }
        else
        {
            prev.next = c2;

        }
        
        return dummy.next;
        
    }
    
    
    public ListNode mergeKLists(ListNode[] lists, int si, int end)
    {
        if(si >= end)
        {
            return si > end ? null : lists[si];
        }
        
        int mid = (si+end)/2;
        
        return merge(mergeKLists(lists, si, mid), mergeKLists(lists,mid+1,end));
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        return mergeKLists(lists, 0, lists.length-1);
    }
}