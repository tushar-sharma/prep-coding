/* 
 * using a class
 */ class Stack {
    constructor() { 
        this.items = [ ];
    }

    push(element) {
        this.items.push(element);
    }

    get(index) {
        return this.items[index];
    }
}

let st = new Stack();

st.push(5);
st.push(8);

console.log(st);
console.log(st.get(1));
