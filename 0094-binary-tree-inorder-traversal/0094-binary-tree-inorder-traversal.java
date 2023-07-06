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
    public List<Integer> listNodes = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return listNodes;
        inorderTraversal(root.left);
        listNodes.add(root.val);
        inorderTraversal(root.right);
        return listNodes;
    }
}