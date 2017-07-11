/*
LINKED LIST/ DOUBLY LINKED LIST

Ordered set of data elements, each containing a link to its successor
and in case of doubly linked list, also its predecessor.
http://www.geeksforgeeks.org/linked-list-set-1-introduction/
*/


/*
// Big O //

Insert: O(1)
Remove: O(1)
[if going to front of list, otherwise O(n)]
*/

///////////////////////
// Implementation(s) //
///////////////////////

LinkedList list = new LinkedList();



/////////////////////
// Common Commands //
/////////////////////

list.add(Object o);  //appends specified element to end of list
list.add(int index, Object o);  // adds to specified position in list, throws
								// exception if out of range
list.addLast(Object o);  //appends specified element to end of list
list.addFirst(Object o);  //appends specified element to front of list
list.clear();
list.element();  //retrieves, doesn't remove first element of list
list.get(int index);
list.getFirst(); //retrieves first element
list.getLast();
list.peekFirst(); //retrieves first element
list.peekLast();
list.pollFirst();  //retrieves and removes first element
list.pollLast();
list.remove(Object o);  //removes first occurence of element in list
list.removeFirst();  //removes and returns first item in list
list.removeLast();   //removes and returns last item in list
list.set(int index, Object o); 	//replace item at index with element
list.size();
list.toArray(); //returns an array containing all elements in list



///////////////////////////////
// Linked List without class //
///////////////////////////////

public class Node{
	Node next;
	int data;
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedList {
	Node head;

	public void append(int data) {
		if (head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}

	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}

	public void deleteWithValue(int data) {
		if(head == null){ return; }
		if(head.data == data){
			head = head.next
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.data == data){
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
}