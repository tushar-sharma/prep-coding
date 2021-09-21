//create hashmap
//
const map1 = new Map();

map1.set("a", 100);

map1.set("b", 200);

map1.set("c", 300);

console.log(map1.get("a"));

console.log(map1.get("z"));


console.log(map1.has("c"));

console.log(map1.has("3"));


map1.set("c", 900);

map1.forEach( function(value, key) {
    console.log(key + " " + value);
});
