# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def checkSum(self,
                curr: TreeNode,
                accumulator : int,
                targetSum : int):

        if (curr == None):
            return False

        accumulator += curr.val

        if (accumulator == targetSum and curr.left == None and curr.right == None):
            return True

        return self.checkSum(curr.left,
                             accumulator,
                             targetSum) or self.checkSum(curr.right,
                                                         accumulator,
                                                         targetSum)

    def hasPathSum(self, root: TreeNode, targetSum: int) -> bool:

        if (root == None):
            return False

        if (root.val == targetSum and root.left == None and root.right == None):
            return True

        return self.checkSum(root.left,
                             root.val,
                             targetSum) or self.checkSum(root.right,
                                                         root.val,
                                                         targetSum)
