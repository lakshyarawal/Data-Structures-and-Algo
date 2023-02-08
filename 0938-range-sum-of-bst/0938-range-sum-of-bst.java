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
    
    int totalSum;
    
    public void calcSum(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >= low && root.val <= high) totalSum += root.val;
        if(low < root.val) calcSum(root.left, low, high);
        if(high > root.val) calcSum(root.right, low, high);
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        totalSum = 0;
        calcSum(root, low, high);
        return totalSum;
    }
}