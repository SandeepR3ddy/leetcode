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
class Solution {
    
    static int cameras = 0;
    
    public int solve(TreeNode node)
    {
      if(node  == null)
      {
         return 1;    
      }
    
     int lc = solve(node.left);
     int rc = solve(node.right);
        
      if(lc == -1 || rc == -1)
      {
         cameras++;
          return 0;
      }
      
      if(lc == 0 || rc == 0)
      {
        return 1;    
      }
        
        return -1;
    }
        
    
    
    
    public int minCameraCover(TreeNode root) {
        
        cameras = 0;
        if(solve(root) == -1)
        {
            cameras++;
        }
        
        return cameras;
    }
}