"""
  Implementation of stack
  push(x) to insert x into stack
  pop() to return top most element
  peek() to print top most element
  isEmpty to check if stack is empty or not
  size() to print the size of the stack
 **/
"""
class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None

class CustomStack(object):
    def __init__(self):
        self.head = None
        self.size = 0

    def push(self, value):

        curr = Node(value)
        curr.next = self.head
        self.head = curr
        self.size += 1

    def pop(self):
        ret = None
        if self.head != None:
            ret = self.head.value
            self.head = self.head.next
            self.size-= 1

        return ret

    def peek(self):
        ret = None
        if self.head != None:
            ret =  self.head.value

        return ret

    def size(self):
        return self.size

if __name__=="__main__":
    cs = CustomStack()

    cs.push(4)
    cs.push(3)

    assert cs.peek() == 3

    cs.push(2)

    assert cs.pop() == 2

    assert cs.pop() == 3

    assert cs.pop() == 4
