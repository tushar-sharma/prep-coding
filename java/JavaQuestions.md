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

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Example](../java/SortAString.java)

4. When would you use a private constructor? Give one example where you would use it?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Yes. We could use for creating Singleton class [Example](../java/Singleton.java)


5. Which of the following types cannot be used as the parameter for a switch statement?

```bash
a. char

b. boolean

c. byte

d. int
```

7. What are Wrapper classes?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.

8. What's difference between Stack Memory and Heap ?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stack Memory is used for memory allocation and execution of thread. Access to this is faster than heap memory.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Heap space in used for dynamic memory allocation for Java Objects at runtime. New objects are created in heap memory and refereces are stored in stack memory. Java thorws **java.lang.OutofMemoryError**. It's not threadsafe, unlike stack, need synchronization.

9. Does Java support multiple inheritance? How to implement it?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; No. However we can implement multiple interfaces.

```java
public interface Foo() {
    void fooDsp();
}

public interface Bar() {
    void barDsp();
}

public class Test implements Foo, Bar {
    public void fooDsp() {
        System.out.println("Foo called");
    }

    public void barDsp() {
        System.out.println("Bar called");
    }
}
```

Before Java 8, interfaces could only define abstract methods. So this wont work anymore.
