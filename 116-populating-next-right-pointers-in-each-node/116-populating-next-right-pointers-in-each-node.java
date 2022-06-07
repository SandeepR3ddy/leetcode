/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
        {
            return root;
        }
        
        
        LinkedList<Node> que = new LinkedList<>();
        
        que.add(root);
        
        Node prev = null;
        
        while(que.size() > 0)
        {
           int size = que.size();
            
            prev = null;
            
            while(size-- > 0)
            {
                Node node = que.removeFirst();
                
                node.next = prev;
                
                prev = node;
             
                if(node.right != null)
                {
                    que.addLast(node.right);
                }
                
                   
                if(node.left != null)
                {
                    que.addLast(node.left);
                }
                
                
            }
        }
        return root;
    }
}