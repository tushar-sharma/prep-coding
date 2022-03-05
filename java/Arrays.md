## Arrays

### Create an array 

#### Defaul initialization

```java
int n = 5; // number of items
int[] num = new int[n];
```
#### With initial values 

```java
import java.util.Arrays;

int n = 5; // number of items
int[] num = new int[n];

Arrays.fill(num, -1);

```

### With fixed initial values

```java
int[] num = {1, 2, 3, 4};
```

### Sort an array in ascending order

```java
import java.util.Arrays;

int[] nums = { 4, 5, 9, 1};

Arrays.sort(nums);
```