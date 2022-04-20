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
    
    public ListNode mergeTwoLists(ListNode l1,ListNode l2)
    {
        
        ListNode dummy = new ListNode(-1),prev = dummy,c1 = l1,c2 = l2;
        
        while(c1 != null && c2 != null)
        {
            if(c1.val < c2.val)
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
        
        prev.next = (c1 == null) ? c2 : c1;
        
        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
    
    
    public ListNode mergeKLists(ListNode[] lists, int si,int ei) {
    
        if(si >= ei)
        {
            return (si > ei) ? null : lists[si] ;      
        }
     
        int mid = (si+ei)/2;
        
      return mergeTwoLists(mergeKLists(lists,si,mid), mergeKLists(lists,mid+1,ei));
    }
        
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        return mergeKLists(lists,0,lists.length-1);
        
    }
}