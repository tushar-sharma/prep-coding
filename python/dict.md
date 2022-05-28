## Dictionary


 ### Initialization
 
 #### as int
 
 ```python
 from collections import defaultdict
 foo = defaultdict(int)
 
 foo[3] = 4
 ```

#### as list

```python
foo = defaultdict(list)
foo[2].append(3)
```

#### Iteration

```python
foo = defaultdict()
for k,v in foo.items():
    ...
```
