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
### Create a deep copy of a list

```java
List<String> oldList = new ArrayList<>();
List<String> newList = new ArrayList<>(oldList);
```

### List of List

```java
List<List<String>> myList = new ArrayList<>();
```
