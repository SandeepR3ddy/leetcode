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
    
    public static class Pair{
        
        int withrobbery = 0;
        int withoutrobbery = 0;
    }
    
    public Pair solve(TreeNode root)
    {
        if(root == null)
        {
            return new Pair();
        }
        
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        
        Pair myans = new Pair();
        
        myans.withrobbery = left.withoutrobbery + right.withoutrobbery + root.val;
        myans.withoutrobbery = Math.max(left.withrobbery, left.withoutrobbery) + Math.max(right.withrobbery, right.withoutrobbery);
    
        return myans;
        
    }
    
    
    public int rob(TreeNode root) {
    
        Pair ans = solve(root);
        
        return Math.max(ans.withrobbery, ans.withoutrobbery);
        
        
    }
}