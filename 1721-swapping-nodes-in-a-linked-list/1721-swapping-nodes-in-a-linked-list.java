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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode tempp = head;
        
        int n = 0;
        
        while(tempp != null)
        {
            tempp = tempp.next;
            n++;
        }
         
        int endk = n - k + 1;
        
        
        ListNode temp1 = head;
        
        ListNode temp2 = head;
        
        
        while(k-- > 1)
        {
            temp1 = temp1.next;
        }
        
        while(endk-- > 1)
        {
            temp2 = temp2.next;
        }
        
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
        
        return head;
    }
}