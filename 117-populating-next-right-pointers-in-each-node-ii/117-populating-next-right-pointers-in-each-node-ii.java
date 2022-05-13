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
        
      ArrayDeque<Node> que = new ArrayDeque<>();
        
        if(root == null)
        {
            return root;
        }
        que.push(root);
        
        while(que.size() != 0)
        {
            int size = que.size();
            while(size > 0)
            {
                Node node = que.removeFirst();
                if(size == 1)
                {
                node.next = null;
                }
                else
                {
                    node.next = que.getFirst();
                }
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
                size--;
            }
        }
        return root;
    }
}