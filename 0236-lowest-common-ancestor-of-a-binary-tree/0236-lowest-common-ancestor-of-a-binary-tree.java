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
    
    public boolean populate(TreeNode root, TreeNode curr, Deque<TreeNode> list){
        if(root == curr){
            list.offer(curr);
            return true;
        }
        if(root == null){
            return false;
        }
        if(populate(root.left, curr, list)){
            list.offer(root.left);
            return true;
        }
        else if(populate(root.right, curr, list)){
            list.offer(root.right);
            return true;
        }
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> list1 = new ArrayDeque<>();
        Deque<TreeNode> list2 = new ArrayDeque<>();

        if(populate(root, p, list1)){
            list1.offer(root);
        }
        
        if(populate(root, q, list2)){
            list2.offer(root);
        }
        
        while(!list1.isEmpty() && !list2.isEmpty()){
            if(list1.size() > list2.size()){
                list1.pop();
            }
            else if(list2.size() > list1.size()){
                list2.pop();
            }
            else{
                TreeNode node = list1.pop();
                if(node == list2.pop()){
                    return node;
                }
            }
        }
        return null;
    }
}