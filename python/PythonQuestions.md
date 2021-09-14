# Python Questions

1. What's the difference between tuple & list?

2. What's the difference between return and yield in python?

`return` statement returns only a single value to the caller. 'yield' statement returns a generator object.

```python
# return example

myList = [1, 2, 3, 4, 8]
def test(myList):
    for value in myList:
        if (i % 2 == 0):
	    return i
	    
print(test(myList))

print(test(myList))
# print 2
# print 2

# yield example

def testY(myList):
    for e in myList:
        if e % 2 == 0:
	        yield e

obj = testY(myList)

print(next(obj))

print(next(obj))

# print 2

# print 4

```

3. What's the output?

```python
class Parent(object):
    x = 1

class Child1(Parent):
    pass

class Child2(Parent):
    pass

print(Parent.x, Child1.x, Child2.x)

Child1.x = 2
print(Parent.x, Child1.x, Child2.x)

Parent.x = 3
print(Parent.x, Child1.x, Child2.x)
```

4. What's the output?

```python

def foo(f):
    def wrapper(*args, **kwargs):
       g = f(*args, **kwargs)
       value = list(g)[::-1]
       return "".join(str(x) for x in value)
    return wrapper

def bar(f):
    def wrapper(*args, **kwargs):
        g = f(*args, **kwargs)
        return '$' + str(abs(g))

    return wrapper

@foo
@bar
def myFunc(arr):
    return arr[-1] * 2

arr = [-1 , 2, 3, -4]
print(myFunc(arr))
```

5. Implement function overloading in python?

6. What is pickling and unpickling? 

**7. Create 2D array in python**

```python
m = 3 
n = 2
# create m X n array
arr = [[0] * n for i in range(m)]
```

## Pandas

### Axis in pandas mean?

axis=0 means along the rows, axis=1 means long the columns. 
