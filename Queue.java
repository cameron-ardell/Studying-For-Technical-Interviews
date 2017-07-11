/*
QUEUE

Linear data structure of flexible size, FIFO (First In First Out)

In Java, Queue does not directly have a data structure, but instead
you can write it as a LinkedList or Priority Queue. A linked list is
pretty standard queue implementation.
*/

/*
// Big O //	

Insert: O(1)
Remove min/ max: O(1)
*/

///////////////////////
// Implementation(s) //
///////////////////////

Queue queueA = new LinkedList();
Queue<Object> queueB = new LinkedList<Object>();


/////////////////////
// Common Commands //
/////////////////////

queue.add(); 	//adds element at tail (if LinkedList) or according
			 	//  to priortiy if (priority queue)
queue.peek(); 	//view head of queue w/o removing it. returns null if empty
queue.poll(); //removes and returns head of queue. returns nnull if empty



/////////////////////////
// Queue without class //
/////////////////////////
public static class Queue {
	private static class Node {
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}

	private Node head; // remove from head
	private Node tail; // add things here

	public boolean isEmpty() {
		return head == null;
	}
	public int peek() {
		return head.data;
	}
	public void add(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = node;
		}
	}
	public int remove() {
		int data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
	}
}
