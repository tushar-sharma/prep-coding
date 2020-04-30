# Java Questions

**1. What's the difference between String, String Builder, String Buffer? Which one is thread safe class? Which one is faster, String Buffer or String builder?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Strings** are immutable. The object is stored in Constant String Pool. Every immutable object in Java is thread safe ,that implies String is also thread safe.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **StringBuffer** is mutable means one can change the value of the object . The object created through StringBuffer is stored in the heap. StringBuffer has the same methods as the StringBuilder , but each method in StringBuffer is synchronized that is StringBuffer is thread safe.

But being thread safe has disadvantages too as the performance of the StringBuffer hits due to thread safe property . Thus StringBuilder is faster than the StringBuffer when calling the same methods of each class.

String Buffer can be converted to the string by using toString() method

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **StringBuilder** is same as the StringBuffer , that is it stores the object in heap and it can also be modified . The main difference between the StringBuffer and StringBuilder is that StringBuilder is also not thread safe. StringBuilder is fast as it is not thread safe .

**2. What's the output?**

``` bash
String str1 = "hello";

String str2 = str1;

String str3 = new String("hello");

StringBuffer str4 = new StringBuffer("hello");

StringBuilder str5 = new StringBuilder("hello");

/* check equality */

System.out.println(str1 == str2);

System.out.println(str1 == str3);

System.out.println(str2 == str3);

System.out.println(str1.equals(str2));

System.out.println(str1.equals(str3));

System.out.println(str3.equals(str4));

System.out.println(str3.equals(str5.toString()));

```

**3. What's the output?**

```bash
interface MyInterface {
public void method1();
public void method2();
}

class MyClass implements MyInterface {
public void method1() {
    System.out.println( "method 1" );
}
}

public class Test {
public static void main( String args[] ) {
    MyClass c1 = new MyClass();
    c1.method1();
    c1.method2();
}
}
```

**3. Sort a String in Java**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Example](../java/SortAString.java)

**4. When would you use a private constructor? Give one example where you would use it?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Yes. We could use for creating Singleton class [Example](../java/Singleton.java)


**5. Which of the following types cannot be used as the parameter for a switch statement?**

```bash
a. char

b. boolean (Answer)

c. byte

d. int
```

**7. What are Wrapper classes?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.

**8. What's difference between Stack Memory and Heap?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stack Memory is used for memory allocation and execution of thread. Access to this is faster than heap memory.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Heap space in used for dynamic memory allocation for Java Objects at runtime. New objects are created in heap memory and refereces are stored in stack memory. Java thorws **java.lang.OutofMemoryError**. It's not threadsafe, unlike stack, need synchronization.

**9. Does Java support multiple inheritance? How to implement it?**

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
