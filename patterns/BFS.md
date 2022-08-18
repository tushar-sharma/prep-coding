## BFS algorithm


```java
//create a queue
 Deque<Integer> queue = new ArrayDequee<>();
// add first element
queue.offer(start);
// keep track of visited
Set<Integer> visited = new HashSet<>();

while(!queue.isEmpty()) {
    int size = queue.size();
    
    while(size-- > 0) {
        int node = queue.poll();
        
        //do something with node
        // get edges of node 
        List<Integer> edges = ..;
        
        for (int edge : edges) {
            if (!visited.contains(edge)){
                queue.offer(edge);
            }
        }
    }
}
```
