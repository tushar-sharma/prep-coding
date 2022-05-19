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
foo.forEach((key, value) -> {
    System.out.println("key is" + key + " value is " + value);
});
        
```
