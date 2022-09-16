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
    
    public List<TreeNode> nodeToRootPath(TreeNode root, TreeNode node)
    {
         if(root == null)
         {
             return new ArrayList<>();
         }
        
        if(root == node)
        {
            
            List<TreeNode> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        
       List<TreeNode> left = nodeToRootPath(root.left,node);
        
        if(left.size() != 0)
        {
           left.add(root);
            return left;
        }
        
        
       List<TreeNode> right = nodeToRootPath(root.right,node);
        
        if(right.size() != 0)
        {
           right.add(root);
            return right;
        }
        
        return new ArrayList<>();
    }
    
    public void kdown(TreeNode root,int k, TreeNode block, List<Integer> allNodesAtK)
    {
        
        if(root == null || k < 0 || root == block)
        {
            return;
        }
        
        
        if(k == 0)
        {
            allNodesAtK.add(root.val);
            return;
        }
        
        kdown(root.left, k-1, block, allNodesAtK);
        
        kdown(root.right, k-1, block, allNodesAtK);
        
    }
    
    
    
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        
        List<TreeNode> allNodes = nodeToRootPath(root, target);
        
        
        List<Integer> res = new ArrayList<>();
        
        TreeNode block = null;
        
        for(int i = 0;i < allNodes.size();i++)
        {
           
            kdown(allNodes.get(i), k - i, block, res);
            
            block = allNodes.get(i);
             
        }
        
        
        return res;
        
    }
}