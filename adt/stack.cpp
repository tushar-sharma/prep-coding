#include <stack>
#include <iostream>
using namespace std;

/*
 * Remember
 * 1. In C++, stack:: pop() only pops the top element but does not return it.
 * 2. printing the array
 * 3. st.empty()
 */

int main() {

	stack<int> st;

	cout<<"\nPushing element 20";
	st.push(20);

	cout<<"\nPushing element -2";
	st.push(-5);

	cout<<"\nPushing element 5";
	st.push(5);

	cout<<"\nTop element is "<<st.top();

	cout<<"\nPop element "<<st.top();
	st.pop();

	cout<<"\nPop element "<<st.top();
	st.pop();

    cout<<"\nTop element is "<<st.top();

	cout<<"\nPushing element 100";
	st.push(100);

	cout<<"\nPrinting the stack ";
	while(!st.empty()) {
		cout<<st.top()<<" ";
		st.pop();
	}


	return 0;
}
