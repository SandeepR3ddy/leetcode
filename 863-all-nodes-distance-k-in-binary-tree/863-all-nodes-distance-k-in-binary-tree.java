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
    
    public void  helper(TreeNode root, TreeNode target, int k, TreeNode block, List<Integer> ans)
    {
        if(root == null)
        {
            return;
        }
       
        if(k == 0)
        {
            ans.add(root.val);
            // System.out.println(root.val);
            
            return;
        }
        
        if(root.left != block)
        {
            helper(root.left, target, k-1, block, ans);
        }
        if(root.right != block)
        {
            helper(root.right, target, k-1, block, ans);
        }
    }
        
        
    public int solve(TreeNode root, TreeNode target, int k, List<Integer> ans)
    {
        if(root == null)
        {
            return 0;
        }
        if(root == target)
        {
            helper(root.left , target, k - 1,null, ans);
            helper(root.right, target, k - 1,null , ans);
            if(k == 0)
            {
                ans.add(root.val);
            }
            return 1;
        }
        
        int left = solve(root.left,target, k, ans);
        
        if(left > 0)
        {
            helper(root, target, k - left, root.left, ans);
            return left+1;
        }
         
        int right =  solve(root.right, target, k, ans);
     
        if(right > 0)
        {
            helper(root, target, k - right, root.right, ans);
            return right+1;
        }    
        return 0;
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();
        
        solve(root, target, k, ans);
        
        return ans;
    }
}