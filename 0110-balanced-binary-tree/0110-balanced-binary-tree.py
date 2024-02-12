# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        left_height = self.depth(root.left)
        right_height = self.depth(root.right)
        if abs(left_height - right_height) > 1:
            return False
        return self.isBalanced(root.right) and self.isBalanced(root.left)
    
    def depth(self, root):
        if root == None:
            return 0
        return max(self.depth(root.right),self.depth(root.left))+1