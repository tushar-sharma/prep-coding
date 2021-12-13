## Iterations

1. List array 

```java

public void test(List<String> words ) {
    for (String word : words) {
        System.out.println(word);
    }
}

```

2. Arrays

```java
public void dsp(int[]  nums) {
    System.out.println(Arrays.toString(nums));
    for (int num : nums) {
        System.out.printn(num);
    }
}
```

3. Stack 

```java
Deque<Character> stack = new ArrayDeque<>();
stack.push('a');
stack.push('b');

Iterator<Character> iter = stack.iterator();

while(iter.hasNext()){
    System.out.println(iter.next());
}
```