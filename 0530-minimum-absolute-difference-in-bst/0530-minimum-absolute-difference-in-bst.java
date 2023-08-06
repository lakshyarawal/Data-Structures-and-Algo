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
    int minDif = Integer.MAX_VALUE;
    
    public void recDif(TreeNode root, int lo, int hi){
        if(root == null) return;
        
        if(lo != Integer.MIN_VALUE) minDif = Math.min(minDif, root.val - lo);
        if(hi != Integer.MAX_VALUE) minDif = Math.min(minDif, hi - root.val);
        
        if(root.left != null) recDif(root.left, lo, root.val);
        if(root.right !=null) recDif(root.right, root.val, hi);
        
    }
    
    public int getMinimumDifference(TreeNode root) {
        recDif(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return minDif;
    }
}