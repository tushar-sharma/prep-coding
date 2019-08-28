/*
 * create a prototype function
 */

//create an object
let obj1 = { };

//create object using constructor function
function MyFunc(foo, bar) {
    this.foo = foo;
    this.bar = bar;
}

MyFunc.prototype.concat = function() {
    return this.foo + " and " + this.bar;
}

let obj2 = new MyFUnc("first", "second");

console.log(obj2.concat());
