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
    List<Integer> vals;
    int curIdx;
    
    public void traversal(TreeNode root){
        if(root == null) return;
        if(root.left != null) traversal(root.left);
        vals.add(root.val);
        if(root.right != null) traversal(root.right);
    }
    
    public BSTIterator(TreeNode root) {
        vals = new ArrayList<>();
        traversal(root);
        curIdx = -1;
    }
    
    public int next() {
        curIdx++;
        return vals.get(curIdx);
    }
    
    public boolean hasNext() {
        if(curIdx + 1 < vals.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */