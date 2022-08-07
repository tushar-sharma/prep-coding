import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

// Create a stack
Deque<Integer> stack = new ArrayDeque<>();

// Push elements to stack
stack.push(5);
stack.push(3);
stack.push(-1);
stack.push(1);
stack.push(20);

// Get the top element in stock 
int top = stack.pop();
System.out.println("Top elment is " + top);

// peek element 
top = stack.peek();
System.out.println("Peek Top elment is " + top);

// print the size of stack
System.out.println("Size of the stack is " + stack.size());

// remove an element by value 
stack.remove(3);

// Iterate a stack 
while (!stack.isEmpty()) {
    System.out.println(stack.pop());
}
