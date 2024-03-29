/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    TreeNode curr = null;
    
    public BSTIterator(TreeNode root) {
        
        curr = root;
    }
    
    private TreeNode getRightMostNode(TreeNode node, TreeNode curr)
    {
        
        while(node.right != null && node.right != curr)
        {
            node = node.right;
        }
        
        return node;
        
    }
    
    public int next() {
        
            int rv = -1;
        
        while(curr != null)
        {
          TreeNode left = curr.left;
      
            
          if(left == null)
          {
              rv = curr.val;
              curr = curr.right;
              
              break;
          }
          else
          {
            
              TreeNode right = getRightMostNode(left, curr);
              
              if(right.right == null)
              {
                  right.right = curr;
                  
                  curr = curr.left;
                  
              }
              else
              {
                  right.right = null;
                  
                  rv = curr.val;
                  
                  curr = curr.right;
                  
                  break;
              }   
          }
        }
        return rv;
    }
    
    public boolean hasNext() {
        
        return curr != null;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */