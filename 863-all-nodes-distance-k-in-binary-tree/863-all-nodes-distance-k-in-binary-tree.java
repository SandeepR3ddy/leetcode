/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans)
    {
        if(root == null || k < 0)
        {
            return;
        }
        
        if(k == 0)
        {
          ans.add(root.val);
            return;
        }
        
        if(root.left != block)
        kdown(root.left, k-1, block, ans);
        
        if(root.right != block)
        {
            kdown(root.right, k-1, block, ans);
        }
        
    }
    
    public int distanceK(TreeNode root, TreeNode target, int k , List<Integer> ans)
    {
        
        if(root == null || k < 0)
        {
            return 0;
        }
        
        if(root == target)
        {
        
           kdown(root, k, null,  ans);
            
            return 1;
            
        }
        
        
        int ld = distanceK(root.left, target, k, ans);
        
           if(ld > 0)
           {
               kdown(root,k-ld,root.left, ans);
               
               return ld+1;
           }
        
        int rd = distanceK(root.right, target, k, ans);
        
           if(rd > 0)
           {
               kdown(root,k-rd,root.right, ans);
               
               return rd+1;
           }
        
        return 0;
        
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         
        List<Integer> ans = new ArrayList<>();
        
        distanceK(root, target, k, ans);
        
        return ans;
    }
}