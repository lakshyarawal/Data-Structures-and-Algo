/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static ArrayList<TreeNode> ntrp;
    public static boolean nodeToRootPath(TreeNode node,int target){
        if(node==null) return false;
        if(node.val==target){
            ntrp.add(node);
            return true;
        }
        boolean left=nodeToRootPath(node.left,target);
        if(left==true){
            ntrp.add(node);
            return true;
        }
        boolean right=nodeToRootPath(node.right,target);
        if(right==true){
            ntrp.add(node);
            return true;
        }
        return false;
    }
    public void kleveldown(TreeNode node,int k,int curr,TreeNode blocker,List<Integer> ans){
        if(node==null) return;
        if(node==blocker) return;
        if(curr==k){ ans.add(node.val);  return; }
        kleveldown(node.left,k,curr+1,blocker,ans);
        kleveldown(node.right,k,curr+1,blocker,ans);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ntrp=new ArrayList<>();
        nodeToRootPath(root,target.val);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<ntrp.size();i++){
            //  nodes k-i level down from ith node
            if(i==0){
              kleveldown(ntrp.get(i),k-i,0,null,ans);   
            }else{
              kleveldown(ntrp.get(i),k-i,0,ntrp.get(i-1),ans);  
            }
        }
        return ans;
    }
}