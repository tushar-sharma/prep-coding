/* string, number, boolean, etc are immutable
 * where as object are mutable
 * */

let n = 2;

function addTwo(n) {
    n = n + 2;
}

addTwo(n);

console.log(n); //2


let obj = { color : 'red' };

function changeColor(obj) {
    obj.color = "blue";
}

changeColor(obj);

console.log(obj.color); // blue
