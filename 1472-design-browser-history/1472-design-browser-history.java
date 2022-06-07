class BrowserHistory {

    public class ListNode
    {
        String url;
        ListNode prev;
        ListNode next; 
        
        ListNode()
        {
            url = "";
            this.prev = null;
            this.next = null;
        }
        
        ListNode(String url)
        {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }
    
    ListNode head,curr;
    
    
    
    public BrowserHistory(String homepage) {
        
         head = new ListNode(homepage);
        
         curr = head; 
        
    }
    
    public void visit(String url) {
        
        ListNode newNode = new ListNode(url);
        
        curr.next = newNode;
        
        newNode.prev = curr;
        
        curr = curr.next;
        
    }
    
    public String back(int steps) {
        
        while(steps > 0 && curr != head)
        {
            curr = curr.prev;
            steps--;
        }
        
            return curr.url;
    }
    
    public String forward(int steps) {
        
        while(curr.next != null && steps > 0)
        {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */