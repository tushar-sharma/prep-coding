import scala.collection.mutable.Stack

var ints = Stack[Int]()

print("\nPushing element 20")

ints.push(20)

print("\nPushing element -2")

ints.push(-2)

print("\nPushing element 5")

ints.push(5)

print("\nTop element in stack is " + ints.top)

print("\nPop latest element " + ints.pop)

print("\nPop latest element " + ints.pop)

print("\nPushing element 100")
ints.push(100)

print("\nThe stack is  " + ints)

