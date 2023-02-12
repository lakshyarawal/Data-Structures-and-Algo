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
    public void leafArray(TreeNode root, List<Integer> l){
        if(root == null) return;
        if(root.right == null && root.left == null) l.add(root.val);
        leafArray(root.left, l);
        leafArray(root.right, l);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        leafArray(root1, l1);
        leafArray(root2, l2);
        //System.out.println(l1);
        //System.out.println(l2);
        return l1.equals(l2);
    }
}