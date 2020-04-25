# Java Questions

1. What's the difference between String & String Builder vs String String Buffer? Which one is thread safe class? Which one is faster, String Buffer or String builder?


2. What's the output?
```java
String str1 = "hello";
String str2 = str1;
String str3 = new String("hello");

System.out.println(str1 == str2);
System.out.println(str1 == str3);
System.out.println(str2 == str3);
System.out.println(str1.equals(str2));
System.out.println(str1.equals(str3));
```

3. Sort a String in Java

[Example](../java/SortAString.java)

4. When would you use a private constructor?

5. Which of the following types cannot be used as the parameter for a switch statement?

```bash
a. char

b. boolean

c. byte

d. int
```

7. What are Wrapper classes?

The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.

8. What's differnce between Stack Memory and Heap ?

Stack Memory is used for memory allocation and execution of thread. Access to this is faster than heap memory.

Heap space in used for dynamic memory allocation for Java Objects at runtime. New objects are created in heap memory and refereces are stored in stack memory. Java thorws java.lang.OutofMemoryError. IT's not threadsafe, unlike stack, need synchronization.
