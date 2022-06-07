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
    
    public int solve(TreeNode root, int min, int max)
    {
        if(root == null)
        {
            return max-min;
        }
        
        return Math.max(solve(root.left, Math.min(min,root.val), Math.max(root.val,max)),solve(root.right, Math.min(min,root.val), Math.max(root.val,max)));
        
    }
    
    
    public int maxAncestorDiff(TreeNode root) {
        
    return solve(root, root.val, root.val);
        
        
    }
}