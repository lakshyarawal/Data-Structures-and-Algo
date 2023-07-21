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

    public void flatten(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.right = root;
        q.add(root);
        TreeNode prev = dummyNode;
        while(!q.isEmpty()){
            TreeNode curr = q.pollFirst();
            prev.right = curr;
            prev.left = null;
            if(curr.right != null) q.addFirst(curr.right);
            if(curr.left != null) q.addFirst(curr.left);
            prev = curr;
        }
        
        root = dummyNode.right;
    }
}