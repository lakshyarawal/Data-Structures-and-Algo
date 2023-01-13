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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        int max_level = 0;
        LinkedList<TreeNode> dfs = new LinkedList<>();
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        hm.put(root, 0);
        dfs.add(root);
        while(!dfs.isEmpty()){
            TreeNode curr_node = dfs.remove(0);
            int node_level = hm.get(curr_node);
            //System.out.println("Current Node: "+ curr_node.val+" Level: "+ node_level);
            
            if(node_level > max_level){sum = curr_node.val; max_level = node_level;}
            else if(node_level == max_level) sum += curr_node.val;
            if(curr_node.left != null) {
                dfs.add(curr_node.left); 
                hm.put(curr_node.left, node_level+1);
                };
            if(curr_node.right != null){
                dfs.add(curr_node.right);
                hm.put(curr_node.right, node_level+1);
            }
        }
        return sum;
    }
}