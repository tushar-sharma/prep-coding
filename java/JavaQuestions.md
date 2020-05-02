# Java Questions

**1. What's the difference between String, String Builder, String Buffer? Which one is thread safe class? Which one is faster, String Buffer or String builder?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Strings** are immutable. The object is stored in Constant String Pool. Every immutable object in Java is thread safe ,that implies String is also thread safe.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **StringBuffer** is mutable means one can change the value of the object . The object created through StringBuffer is stored in the heap. StringBuffer has the same methods as the StringBuilder , but each method in StringBuffer is synchronized that is StringBuffer is thread safe.

But being thread safe has disadvantages too as the performance of the StringBuffer hits due to thread safe property . Thus StringBuilder is faster than the StringBuffer when calling the same methods of each class.

String Buffer can be converted to the string by using toString() method

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **StringBuilder** is same as the StringBuffer , that is it stores the object in heap and it can also be modified . The main difference between the StringBuffer and StringBuilder is that StringBuilder is also not thread safe. StringBuilder is fast as it is not thread safe .

**2. What's the output?**

```java
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

```java
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
    }
}
```

**4.What's the output?**

```bash
int n = 20;
switch(n)
{
case 10: n = n + 1;
case 15: n = n + 2;
case 20: n = n + 3;
case 25: n = n + 4;
case 30: n = n + 5;
}
System.out.println(n);
```

**5. Sort a String in Java**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Example](../java/SortAString.java)

**6. When would you use a private constructor? Give one example where you would use it?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Yes. We could use for creating Singleton class [Example](../java/Singleton.java)


**7. Which of the following types cannot be used as the parameter for a switch statement?**

```bash
a. char

b. boolean (Answer)

c. byte

d. int
```

**8. What are Wrapper classes?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.

**9. What's difference between Stack Memory and Heap?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stack Memory is used for memory allocation and execution of thread. Access to this is faster than heap memory.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Heap space in used for dynamic memory allocation for Java Objects at runtime. New objects are created in heap memory and refereces are stored in stack memory. Java thorws **java.lang.OutofMemoryError**. It's not threadsafe, unlike stack, need synchronization.

**10. Does Java support multiple inheritance? How to implement it?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; No. However we can implement multiple inheritance using interfaces.

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

**11. What's an abstract class?**

An abstract class is a class whose sole purpose is to be extended.

```java
public abstract class List {
  protected int size;

  public int length() {
    return size;
  }

  public abstract void insertFront(Object item);
}
```

Abstract classes don't allow you to create objects directly.  You can declare a
variable of type List, but you can't create a List object.

```java
List myList;                 // Right on.
myList = new List();         // COMPILE-TIME ERROR.
```
[More Info](https://drive.google.com/open?id=10B8lKlBBkuoI98nhq3H6WbV7B2RtdiWh)

**12. What's a comparable interface?**

Java provides the Comparable interface, which specifies a
method compareTo()

```java
public interface Comparable<T> {
    //post: return < 0 if this smaller than other
    return 0 if this equal to other
    return > 0 if this greater than other
    int compareTo(T other);
}
```
**13. How will you sort an object in Array?**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Example](../java/Book.java)

**14. What's the output?**

```java
class Animal {
    private int x = 2;

    protected String y = "hello";
}

class Cat extends Animal {

    public int getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}

public class A {
    public static void main(String[] args) {

        Cat cat = new Cat();
        System.out.println(cat.getX());

        System.out.println(cat.getY());
    }
}

```

**15. What's the output?**

```java
class Animal {
  public void dsp() {
    System.out.println("animal");
   }

    public void foo(){
      System.out.println("foo");
    }
}

class Mammal extends Animal { }

class Cat extends Mammal {
  public void dsp() {
    System.out.println("cat");
  }
}
public class MyClass {
    public static void main(String args[]) {

        Mammal m1 = new Cat();
        m1.dsp();

        Mammal m2 = new Cat();
        Cat c1 = (Cat) m2;
        c1.dsp();

       Cat c2 = new Cat();
       c2.foo();

       Mammal m3 = new Mammal();
       Cat c3 = (Cat) m3;
  }
}

```

**16. Difference between static vs dynamic polymorphism?**

eg function overloading & funciton overriding.

**17. What does the “static” keyword mean ? Can you override private or static method in Java ?**

The static keyword denotes that a member variable or method can be accessed, without requiring an instantiation of the class to which it belongs. A user cannot override static methods in Java, because method overriding is based upon dynamic binding at runtime and static methods are statically binded at compile time.

**18. What is an iterator interface? difference between fail-fast and fail-safe iterator?**

An iterator over a collection. It has 3 methods

1. next() : for stepping over next element and obtaining it:
2. hasNext() :  used for checking if there's at least one element left to iterate over.
3. remove()

```java
while (iter.hasNext()) {
    String next = iter.next();
    System.out.println(next);

    if( "TWO".equals(next)) {
        iter.remove();
    }
}
```

The Iterator's fail-safe property works with the clone of the underlying collection and thus, it is not affected by any modification in the collection. All the collection classes in java.util package are fail-fast, while the collection classes in java.util.concurrent are fail-safe. Fail-fast iterators throw a ConcurrentModificationException, while fail-safe iterator never throws such an exception.

**19. What's the difference between interface and abstract class ?**

Java provides and supports the creation both of abstract classes and interfaces. Both implementations share some common characteristics, but they differ in the following features:

1. All methods in an interface are implicitly abstract. On the other hand, an abstract class may contain both abstract and non-abstract methods.
2. A class may implement a number of Interfaces, but can extend only one abstract class.
In order for a class to implement an interface, it must implement all its declared methods. However, a class may not implement all declared methods of an abstract class. Though, in this case, the sub-class must also be declared as abstract.
3. Abstract classes can implement interfaces without even providing the implementation of interface methods.
Variables declared in a Java interface is by default final. An abstract class may contain non-final variables.
4. Members of a Java interface are public by default. A member of an abstract class can either be private, protected or public.
5. An interface is absolutely abstract and cannot be instantiated. An abstract class also cannot be instantiated, but can be invoked if it contains a main method.

**20. What's the output? **

```java
      ArrayList<Integer> arr = new ArrayList<>();
      arr.add(1);
      arr.add(2);
      arr.add(3);

      Iterator<Integer> iter = arr.iterator();

      while(iter.hasNext()) {
        System.out.println(iter.next());
        arr.add(4);
      }


      ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

      map.put("First", 10);
      map.put("Second", 20);
      map.put("Third", 30);
      map.put("Fourth", 40);

      Iterator<String> iterator = map.keySet().iterator();

      while (iterator.hasNext()) {
            System.out.println(iterator.next());
            map.put("Fifth", 50);
      }

```


**21. What' the output?**

```java

class Test {
    public static boolean foo(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {

        //Part 1
        int i = 1;
        while (i < 5) {
            if (foo(i)) {
                continue;
            }
            System.out.println(i);
            i++;
        }

        //Part 2

        for (i = 0; i < 5; i++) {
            if (foo(i)) {
                continue;
            }
            System.out.println(i);
        }

}
```
