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
     private int height(TreeNode root) {
    // An empty tree has height -1
        if (root == null) {
          return -1;
        }
         int leftHeight = height(root.left);
         if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
         
         int rightHeight = height(root.right);
         if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
         
         int heightDiff = Math.abs(leftHeight - rightHeight);
         
         if(heightDiff > 1){
             return Integer.MIN_VALUE;
         }
         
         else{
              return 1 + Math.max(leftHeight, rightHeight);
         }
       
      }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
          return true;
        }
        return height(root) != Integer.MIN_VALUE;
    }
}