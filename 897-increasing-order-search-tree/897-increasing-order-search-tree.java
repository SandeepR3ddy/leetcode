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
    
    public void fillarray(TreeNode root,ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            list.add(root.val);
            return;
        }
        
        fillarray(root.left,list);
        list.add(root.val);
        fillarray(root.right,list);
    }
    
    
    
    
    public TreeNode increasingBST(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        fillarray(root,list);    
    
        
        TreeNode newRoot = new TreeNode(list.get(0));
        
        int size = list.size()-1;
        
        int i = 1;
        
        TreeNode temp = newRoot;
        
        while(i <= size)
        {
        
            temp.right = new TreeNode(list.get(i));
            i++;
            temp = temp.right;
        }
        return newRoot;
    }
}