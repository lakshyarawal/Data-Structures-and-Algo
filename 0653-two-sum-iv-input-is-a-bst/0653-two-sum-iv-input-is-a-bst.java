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
    public boolean compFind(TreeNode root, int k, HashSet<Integer> set){
        if(root == null) return false;
        if(set.contains(root.val)) return true;
        set.add(k - root.val);
        return (compFind(root.left, k, set) || compFind(root.right, k, set));
    }
    public boolean findTarget(TreeNode root, int k) {
         HashSet<Integer> set=new HashSet();  
        
        return compFind(root, k, set);
    }
}