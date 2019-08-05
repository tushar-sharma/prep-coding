/*
 * IIFE
 */

//function declaration
//
function myFunc() {
    console.log("name");
}

//function  expression
//
const ret = function () {
    return {
        age : 2
    }
}

//IIFE
//
(function logger() {
    console.log("logging");
}());

//impelement encapsulation : define private scope
//
const myret = ( function() {
    const title = "manager";
    return  {
        printTitle : function () {
            console.log(title);
        }
    }
}());


myret.printTitle();

const ret2 = ( function () {
    let version = 2;
    return function () {
        console.log("version is " + version);
    }
}());

ret2();
