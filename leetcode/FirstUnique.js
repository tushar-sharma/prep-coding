let assert = require('assert');
/**
 * @param {string} s
 * @return {number}
 */

let firstUniqueChar = function(s) {

    const myMap = {};

    //TODO: remember
    for (const elem of s) {
        if (elem in myMap) {
            myMap[elem] = myMap[elem] + 1;
        } else {
            myMap[elem] = 1;
        }
    }

    for (let i = 0; i < s.length; i++) {
        if (myMap[s[i]] == 1) {
            return i;
        }
    }

    return -1;
}

assert.equal(firstUniqueChar("leetcode"), 0);

assert.equal(firstUniqueChar("loveleetcode"), 2);
