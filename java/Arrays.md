# Arrays

## 1D array

#### Default initialization

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

### Print an array 

<pre><code>
int[] nums = {4, 5, 9, 1};
<del>System.out.println(num)</del>;

for (int n : nums) {
    System.out.println(n);
}
</pre></code>


### Length of an array

```java
int[] num = {5, 2, 3};
int len = num.length;
```

## 2D array 

### With fixed initial values

```java
int[][] nums = {
    {1, 2},
    {3, 4},
    {5, 6}
};
```

### Sort an array in ascending order

```java
import java.util.Arrays;

Arrays.sort(nums, (b,a) -> Integer.compare(b[0], a[0]));
```

### Sort an array in ascending order

```java
Arrays.sort(nums, (b,a) -> Integer.compare(a[0], b[0]));
```

### Print an array 

```java
for (int[] num : nums){
    for (int n : num){
        System.out.print(n + " ");
    }
    System.out.println();
}
```
