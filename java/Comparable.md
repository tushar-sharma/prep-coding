## Comparable

```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Node implements Comparable<Node>{
  int age;
  
  public Node(int age){
      this.age = age;
  }
  
  public int getAge() {
      return age;
  }
  
  @Override
  public int compareTo(Node other){
      return Integer.compare(this.age, other.age);
  }
}

class HelloWorld {
    public static void main(String[] args) {
    
        List<Node> list = new ArrayList<>();
        
        list.add(new Node(99));
        list.add(new Node(5));
        list.add(new Node(102));
        
        Collections.sort(list);
        
        for (Node node : list){
            System.out.println(node.getAge() + "\n");
        }
    }
}
```
