class Solution:

    def recCheckSum(self,
                    curr: TreeNode,
                    accumulator,
                    targetSum,
                    paths,
                    parent):

        if curr == None:
            return False

        accumulator += curr.val

        parent.append(curr.val)

        if accumulator == targetSum and curr.left == None and curr.right == None:
            paths.append(parent)


        self.recCheckSum(curr.left, accumulator, targetSum, paths, parent[:])

        self.recCheckSum(curr.right, accumulator, targetSum, paths, parent[:])

    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:

        paths = []

        if root == None:
            return paths

        if root.val == targetSum and root.left == None and root.right == None:
            temp = []
            temp.append(root.val)

            paths.append(temp)

            return paths

        self.recCheckSum(root.left, root.val , targetSum, paths, [root.val])

        self.recCheckSum(root.right, root.val , targetSum, paths, [root.val])

        return paths
