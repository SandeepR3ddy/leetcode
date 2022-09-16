
class Solution {
    
    public TreeNode getRightMostNode(TreeNode root, TreeNode curr)
    {
        while(root.right != null && root.right != curr)
        {
            root = root.right;
        }
    
    return root;
        
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
     
        List<Integer> ans = new ArrayList<>();
        
        if(root == null)
        {
            return ans;
        }
        
        TreeNode curr = root;
        
        while(curr != null)
        {
            TreeNode left = curr.left;
            
            if(left == null)
            {
                ans.add(curr.val);
                curr = curr.right;
            }
            else
            {
                
                TreeNode right = getRightMostNode(left, curr);
                
                if(right.right == null)
                {
                   right.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }
                else
                {
                    right.right = null;
                    curr = curr.right;
                }
            }
                
        }
        return ans;
        
    }
}