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
    List<Integer> inorder;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder = new ArrayList<>();
        populateInorder(root);
        return inorder;
        
    }
    
    private void populateInorder(TreeNode root){
        if(root == null){
            return;
        }
        populateInorder(root.left);
        inorder.add(root.val);
        populateInorder(root.right);
    }
}