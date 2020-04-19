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

3. What's the output?

```java
String str1 = "Hello World!";
str1.substring(1,4).concat("abc").toUpperCase().trim().replace('A', 'B');
System.out.println(str1);
```

4. Sort a String in Java

[Example](../master/leetcode/SortAString.java)
