# Javascript

1. What's an closure in javascript?

A closure is a function defined inside another function (called parent function) and has access to the variable which is declared and defined in parent function scope.

2. What is IIFE (Immediately Invoked Function Expression) ?

3. What are promises in JS and why they are useful?

It's used for handling asynchronous interactions in a sequential manner. They are especially useful when we need to do an async operation and THEN do another async operation based on the results of the first one.

4. Find first unique character in a string?

5. Differnce between `==` and `===`.

```bash
== means comparison between operands with type coercion

and

=== means comparison between operands without type coercion.

Type coercion in JavaScript means automatically converting data types to other data types.

123 == "123"  // Returns true, because JS coerces string "123" to number 123
              // and then goes on to compare `123 == 123`.

123 === "123" // Returns false, because JS does not coerce values of different types here.
```