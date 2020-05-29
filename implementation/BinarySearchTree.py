class Node:
    def __init__(self, value):
        self._left = None
        self._right = None
        self._value = value

    @property
    def value(self):
        return self._value


class BinarySearchTree:
    def __init__(self):
        self._root = None

    def insert_num(self, num, curr):

        if (curr == None):
            curr = Node(num)

        if curr.value > num:
            curr._left = self.insert_num(num, curr._left)

        elif curr.value < num:
            curr._right = self.insert_num(num, curr._right)

        return curr


    def insert(self, num):
        self._root = self.insert_num(num, self._root)

    def preorder(self):

        self.preorder_dsp(self._root)

    def preorder_dsp(self, curr):

        if (curr == None):
            return

        print(curr.value)

        self.preorder_dsp(curr._left)

        self.preorder_dsp(curr._right)




if __name__ == "__main__":
    nums = [50, 15, 72, 49, 73]

    bst = BinarySearchTree()

    for num in nums:
        bst.insert(num)

    bst.preorder()
