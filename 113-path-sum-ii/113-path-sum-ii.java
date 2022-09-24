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

    public void pathSum(TreeNode root, int targetSum,List<Integer> smallans, List<List<Integer>> ans)
    {
             if(targetSum == 0 && root.left == null && root.right == null)
             {
                 
                 List<Integer> base = new ArrayList<>(smallans);
                 ans.add(base);
                 return;
             }
    
            if(root.left != null)
            {
                smallans.add(root.left.val);
                pathSum(root.left, targetSum - root.left.val, smallans, ans);
                smallans.remove(smallans.size()-1);
            }
    
            if(root.right != null)
            {
                smallans.add(root.right.val);
                pathSum(root.right, targetSum - root.right.val, smallans, ans);
                smallans.remove(smallans.size()-1);
            }
    
    
    return ;
    
    
    
    }    
    
    
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> smallans = new ArrayList<>();
        
        if(root == null)
        {
        return ans;    
        }
        
        smallans.add(root.val);
        
         pathSum(root, targetSum - root.val, smallans, ans);

        return ans;
        
    }
}