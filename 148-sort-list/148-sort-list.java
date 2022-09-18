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
    
    public ListNode[] segregate(ListNode head, int pivotidx)
    {
        
        ListNode lefthead = new ListNode(-1);
        
        ListNode righthead = new ListNode(-1);
        
        ListNode left = lefthead, right = righthead, curr = head, pivotNode = head;
        
        int idx = 0;
        
        
        while(pivotidx-- > 0)
        {
            pivotNode = pivotNode.next;
        }
        
        
        
        while(curr != null)
        {
            
            if(curr != pivotNode)
               {
               if(curr.val <= pivotNode.val)
            {
                
                left.next = curr;
                left = left.next;
            }
            else 
            {
                right.next = curr;
                right = right.next;
            }
               }
            curr = curr.next;
        }
        
        left.next = null;
        
        right.next = null;
        
        pivotNode.next = null;
        
        return new ListNode[]{lefthead.next, pivotNode, righthead.next};
        
    }
    
    
    public int count(ListNode head)
    {
       int res = 0;
        
        while(head != null)
        {
            head = head.next;
            res++;
        }
        
    return res;
    
    }
    
    public ListNode[] merge(ListNode[] left, ListNode pivotNode, ListNode[] right)
    {
        if(left[0] != null && right[0] != null)
        {
            
            left[1].next = pivotNode;
            pivotNode.next = right[0];
            return new ListNode[]{left[0], right[1]};
        }
        else if(left[0] == null)
        {
            pivotNode.next = right[0];
            return new ListNode[]{pivotNode, right[1]};
        }
        else if(right[0] == null)
        {
            left[1].next = pivotNode;
            pivotNode.next = null;
            return new ListNode[]{left[0], pivotNode};
        }
        
        return new ListNode[]{pivotNode, pivotNode};
        
        
    }
    
    
    
    public ListNode[] sortList1(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return new ListNode[]{head, head};
        }
     
        int len = count(head);
        
        int pivotidx = len/2;
        
        ListNode[] partition = segregate(head, pivotidx);
        
        ListNode[] left = sortList1(partition[0]);
        
        ListNode[] right = sortList1(partition[2]);
        
       return merge(left, partition[1], right);
    }
    
    
    public ListNode sortList(ListNode head) {
     
        return sortList1(head)[0];
        
}
}