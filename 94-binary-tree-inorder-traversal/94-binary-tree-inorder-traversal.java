class Solution {
    
    public TreeNode getRightMostNode(TreeNode root, TreeNode curr)
    {
        while(root.right != null && root.right != curr)
        {
            root = root.right;
        }
        
        return root;
        
    }
    
    
    public List<Integer> inorderTraversal(TreeNode root) {

     if(root == null)
     {
         return new ArrayList<>();
     }
        
     TreeNode curr = root;
        
     List<Integer> res = new ArrayList<>();
        
      while(curr != null)
      {
          
          TreeNode left = curr.left;
          
          if(left == null)
          {
              res.add(curr.val);
              curr = curr.right;
          }
          else
          {
              TreeNode rightmost = getRightMostNode(left, curr);
              
              if(rightmost.right == null) //thread creation
              {
                  rightmost.right = curr;
                  curr = curr.left;
              }
              else
              {
                  rightmost.right = null;
                  
                  res.add(curr.val);
                  
                  curr = curr.right;
              }
          }
      }
        return res;
    }
}