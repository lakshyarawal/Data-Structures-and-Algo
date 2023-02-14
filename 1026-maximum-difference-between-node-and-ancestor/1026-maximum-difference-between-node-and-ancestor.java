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
    private int maxDif;
    
    public void maxFind(TreeNode node, int maxVal, int minVal){
        if(node.left != null){
            maxDif = Math.max(maxDif, Math.max(Math.abs(node.left.val - maxVal), Math.abs(node.left.val - minVal)));
            maxFind(node.left, Math.max(maxVal, node.left.val), Math.min(node.left.val,minVal));
        }
        if(node.right != null){
            maxDif = Math.max(maxDif, Math.max(Math.abs(node.right.val - maxVal), Math.abs(node.right.val - minVal)));
            maxFind(node.right, Math.max(node.right.val, maxVal), Math.min(node.right.val, minVal));
        }
        return;
    }
    
    public int maxAncestorDiff(TreeNode root) {
        maxDif = 0;
        maxFind(root, root.val, root.val);
        return maxDif;
    }
}