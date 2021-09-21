from collections import deque
"""
Using stack in python
"""

st = deque()

print("Pushing element 20")
st.append(20)

print("Pushing element -2")
st.append(-2)

print("Pushing element 5")
st.append(5)

print("Top element in stack is %s" % st[-1])

assert st[-1] == 5

print("Pop latest element %s" % st.pop())

print("Pop latest element %s" % st.pop())

print("Top element in stack is %s" % st[-1])

assert st[-1] == 20


print("Pushing element in stack 100")
st.append(100)

print("print the stack %s" % st)
