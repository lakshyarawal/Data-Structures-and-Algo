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
    public void recPaths(TreeNode root, List<String> res, String cur){
        if(root == null) return;
        if(cur.length() == 0){
            cur += String.valueOf(root.val);
        }else{
            cur += "->" + String.valueOf(root.val);
        }
        if(root.left == null && root.right == null){
            res.add(cur);
            return;
        }
        recPaths(root.left, res, cur);
        recPaths(root.right, res, cur);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        recPaths(root, res, "");
        return res;
    }
}