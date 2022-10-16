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
    
    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    public TreeNode buildBst(List<Integer> list, int st, int end)
    {
        if(st > end)
        {
            return null;
        }
        
        int mid = (st+end)/2;
        
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = buildBst(list, st, mid-1);
        
        root.right = buildBst(list, mid+1, end);
        
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
         inorder(root,list);
         
        Collections.sort(list);
        
      return buildBst(list,0,list.size()-1);
        
        
    }
}