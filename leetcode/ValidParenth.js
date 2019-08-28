let assert = require('assert');
/**
 * @param s {string}
 * @return {boolean}
 */
let isValid = function(s) {
    let myStack = [];
    let myHashMap = { };
    myHashMap['{'] = '}';
    myHashMap['('] = ')';
    myHashMap['['] = ']';

    for (let i = 0; i < s.length; i++) {

        let ch = s[i];

        //if key exist
        if (ch in myHashMap) {
            myStack.push(ch);
        }

        else {
            for (let key in myHashMap) {
                if (myHashMap[key] === ch) {
                    if (myStack.length === 0) {
                        return false;
                    }

                    if (myHashMap[myStack.pop()] != ch) {
                        return false;
                    }
                }
            }
        }

    }


    if (myStack.length == 0) {
        return true;
    } else {
        return false;
    }

}

assert.equal(isValid("{}"), true);

assert.equal(isValid("()[]{}"), true);

assert.equal(isValid("(["), false);

assert.equal(isValid("{[]}"), true);
