import java.util.Queue;
import java.util.LinkedList;
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
    public int COUNT = 0;
    
    public int goodNodes(TreeNode root) {
        isGood(root, root.val);
        return COUNT;
    }
    public void isGood(TreeNode node, int max_val){
        if (node.val >= max_val) COUNT++;
        max_val = Math.max(max_val, node.val);
        if(node.left != null) isGood(node.left, max_val);
        if(node.right != null) isGood(node.right, max_val);
        return;
    }
}