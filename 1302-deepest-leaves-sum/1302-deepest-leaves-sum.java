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
    public int deepestLeavesSum(TreeNode root) {
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        
        if(root == null)
        {
           return 0;    
        }
        
        queue.add(root);
        
        int val = 0;
        
        while(queue.size() > 0)
        {
            int size = queue.size();
            
            val = 0;
            
            while(size-- > 0)
            {
                TreeNode rn = queue.removeFirst();
                
                val += rn.val;
                
                if(rn.left != null)
                {
                    queue.addLast(rn.left);
                }
                if(rn.right != null)
                {
                    queue.addLast(rn.right);
                }
            }
        }
        return val;
    }
}