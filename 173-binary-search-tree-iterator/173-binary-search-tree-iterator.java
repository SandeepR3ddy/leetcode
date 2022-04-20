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
class BSTIterator {
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode node = root;
		update(node);                                     
	}
	public int next() {
		TreeNode toRemove = stack.pop();
		update(toRemove.right);                           
		return toRemove.val;
	}
	public boolean hasNext() {
		return !stack.isEmpty();    
	}
	public void update(TreeNode node){
		while(node != null){
			stack.add(node);
			node = node.left;
		}
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */