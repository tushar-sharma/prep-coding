&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Strings** are immutable. The object is stored in Constant String Pool. Every immutable object in Java is thread safe ,that implies String is also thread safe.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **StringBuffer** is mutable means one can change the value of the object . The object created through StringBuffer is stored in the heap. StringBuffer has the same methods as the StringBuilder , but each method in StringBuffer is synchronized that is StringBuffer is thread safe.

But being thread safe has disadvantages too as the performance of the StringBuffer hits due to thread safe property . Thus StringBuilder is faster than the StringBuffer when calling the same methods of each class.

String Buffer can be converted to the string by using toString() method

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **StringBuilder** is same as the StringBuffer , that is it stores the object in heap and it can also be modified . The main difference between the StringBuffer and StringBuilder is that StringBuilder is also not thread safe. StringBuilder is fast as it is not thread safe .
