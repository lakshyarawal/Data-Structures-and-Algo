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
    public int maxLevelSum(TreeNode root) {
        // Declare max_sum and max level as - inf
        // do a breadth first approach to find sum of all levels
        // If the sum if more than prev sum update the level and maxSum
        // return this level
        int maxSum = root.val;
        int maxLevel = 1;
        int currLevel = 1;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            int currSum = 0;
            for(int i = 0; i< qLen; i++){
                TreeNode tempNode = queue.poll();
                currSum += tempNode.val;
                /*Enqueue left child */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                /*Enqueue right child */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                } 
            }
            if(currSum > maxSum){
                maxSum = currSum;
                maxLevel = currLevel;
            }
            currLevel++;
        }
        
        return maxLevel;
    }
}