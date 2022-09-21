## Arrays

### Sort an array

```javascript
const nums = [9, 1, 5, 2, 4];

//ascending order
nums.sort((a,b) => {
    return a  - b;
});

console.log(nums);
//[ 1, 2, 4, 5, 9 ]

//descending array
nums.sort((a, b) => {
   return b - a; 
});

console.log(nums);
//[ 9, 5, 4, 2, 1 ]
```
