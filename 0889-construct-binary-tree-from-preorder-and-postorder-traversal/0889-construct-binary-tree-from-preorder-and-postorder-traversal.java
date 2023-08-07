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
    Map<Integer, Integer> index_post = new HashMap();
    Map<Integer, Integer> index_pre = new HashMap();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0;i<preorder.length;i++){
            index_pre.put(preorder[i], i);
            index_post.put(postorder[i], i);
        }
        return dfs(0, preorder.length-1, preorder, postorder); 
    }
    
    public TreeNode dfs(int start, int end, int[] pre, int[] post){
        if(start>end){return null;}
        if(start==end)return new TreeNode(pre[start]);
        TreeNode root = new TreeNode(pre[start]);
        int middle = index_pre.get(post[index_post.get(pre[start])-1]);
        root.left = dfs(start+1, middle-1, pre, post);
        root.right = dfs(middle, end, pre, post);
        return root;
    }
}