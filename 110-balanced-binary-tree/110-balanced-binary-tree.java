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
    
    class BST
    {
        boolean bst = true;
        int ht = -1;
    }
    
    public BST solve(TreeNode root)
    {
        if(root == null)
        {
            return new BST();
        }
        
        BST mypair = new BST();
        
        BST left = solve(root.left);
        
        BST right = solve(root.right);
        
        mypair.bst =  left.bst && right.bst ;
        
        if(mypair.bst == true && Math.abs(left.ht-right.ht) < 2)
        {
            mypair.ht = Math.max(left.ht, right.ht)+1;
        }
        else
        {
            mypair.bst = false;
        }
        
        return mypair;
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        return solve(root).bst;
    }
}