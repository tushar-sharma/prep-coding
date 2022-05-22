## ArrayList

### Initialization

```java
List<Integer> arrayList = new ArrayList<>();

List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
```

 
### Print

```java
for (int elem : arrayList) {
    System.out.println(elem);
}
```
### Sort in ascending order

```java
Collections.sort(arrayList);
```

### Sort in ascending order

```java
Collections.sort(arrayList, Collections.reverseOrder());
```

### Get a value at index i

```java
List<Integer> foo = new ArrayList<>();
int bar = foo.get(0);
```

### Create a deep copy of a list

```java
List<String> oldList = new ArrayList<>();
List<String> newList = new ArrayList<>(oldList);
```

### List of List

```java
List<List<String>> myList = new ArrayList<>();
```
