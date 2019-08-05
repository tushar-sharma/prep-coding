/* closures */

function rem (){
    let n =  5;

    return function() {
        return n;
    }
}

const ret = rem(5);

console.log(ret()); // 5
