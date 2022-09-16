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
    
    public List<TreeNode> nodeToRootPath(TreeNode root, TreeNode target)
    {
        if(root == null)
        {
            return new ArrayList<>();
        }
        
        if(root == target)
        {
         
            List<TreeNode> list = new ArrayList<>();
            
            list.add(root);
            
            return list;
            
        }
        
        List<TreeNode> left = nodeToRootPath(root.left,target);
        
        if(left.size() != 0)
        {
            left.add(root);
            
            return left;
        }
        
        
        List<TreeNode> right = nodeToRootPath(root.right,target);
        
        if(right.size() != 0)
        {
            right.add(root);
            
            return right;
        }
        
        
        return new ArrayList<>();
        
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        List<TreeNode> list1 = nodeToRootPath(root, p);
        
        List<TreeNode> list2 = nodeToRootPath(root, q);
    
        int i = list1.size()-1, j = list2.size()-1;
        
        TreeNode lca = null;
        
        while(i >= 0 && j >= 0)
        {
        
             if(list1.get(i) != list2.get(j))
             {
                 break;
             }
            
            lca = list1.get(i);
            
            i--;
            j--;
            
        }
        
        return lca;
        
    }
}