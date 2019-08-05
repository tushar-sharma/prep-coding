/*
 * two ways to create objects
 */

//literal notation

let myObject = { }

//using Object
const myNewObject  = new Object();

//define properties in object
//
myObject = {
    age : 12,
    name : "bla",
    fn : function () {
        console.log("hello world");
    }
}

myObject.title = "manager";

console.log(myObject);

myObject.fn();
