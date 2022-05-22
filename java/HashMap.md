## HashMap

### Initialization

```java
Map<Integer, Integer> foo = new HashMap<>();
```

### Insertion

```java

Map<Integer, ArrayList> foo = new ArrayList<>(); 
foo.computeIfAbsent(2, t -> new ArrayList<>()).add(4);
```


### Printing


```java
// you cant use local variable inside it
foo.forEach((key, value) -> {
    System.out.println("key is" + key + " value is " + value);
});
      
for (Map.Entry<k, v> foo : map.entrySet()) {
    k key = foo.getKey();
    v value = foo.getValue();
}
```
