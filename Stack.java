/*
STACK

Linear data structure of flexible size, LIFO (Last In First Out)
*/
Stack stack = new Stack();

/////////////////////
// Common Commands //
/////////////////////
stack.empty();	//returns true if stack is empty, else false
stack.peek();	//returns element from top of stack
stack.pop(); 	//removes and returns element from top of stack
stack.push(Object e);	//pushes element to top of stack
stack.search(Object e); //searches for element, returns offset from top or 0.1 if not there



/////////////////////////
// Stack without class //
/////////////////////////
public static class Stack {
	private static class Node {
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}

	private Node top;

	public boolean isEmpty() {
		return top == null;
	}
	public int peek() {
		return top.data;
	}
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	public int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}
}




