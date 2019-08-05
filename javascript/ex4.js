/* check auto semi colon insertion by JS */
function foo()
{
    return {
        color : "green"
    }
}

function bar()
{
     return
    {
        color : "blue"
     }
}

console.log(foo());

console.log(bar());
