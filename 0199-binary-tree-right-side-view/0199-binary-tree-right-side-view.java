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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightValues = new ArrayList<>();
        if(root == null) return rightValues;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int right = -1;
            int i = 0;
            while(i < size){
                TreeNode curNode = q.remove();
                
                if(curNode.left != null) q.offer(curNode.left);
                if(curNode.right != null) q.offer(curNode.right);
                
                right = curNode.val;
                i++;
            }
            rightValues.add(right);
        }
        return rightValues;
    }
}