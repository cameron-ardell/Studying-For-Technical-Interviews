/*
Arrays
stores fixed-size sequential collection of elements of same type

Insert: O(1)
Search: O(n OR log(n) OR n^2)
Remove: O(1) <-- ???
*/
Object[] array = new array[size];
double[] myList = {1.9, 2.9, 3.4, 3.5};

// Common Commands //
Arrays.binarySearch(Object[] a, Object key); // returns index if found, or the negative of where it should be inserted if not in array
Arrays.equals(Primitive_Object[] a, Primitive_Object[] b);	// returns true if two arrays have same # elements
															// and corresponding pairs match
Arrays.fill(Primitive_Object[] a, Primitive_Object val); // populate array with a value, returns nothing
Arrays.sort(Primitive_Object[] a); //sorts in ascending order, returns nothing



/*
Breadth First Search
Algorithm that traverses graph or tree data strucutres. Starting at a given
node, explores all immediately neighboring nodes before moving to next 
level neighbors.
Implement with recursive algorithm, need some sort of is-visited flag.
*/



/*
Depth First Search
Algorithm that traverses graph or tree data structure. Starting at a given
node, it explores as far as possible along each branch before backtracking.

Problem: can miss simple solutions, traversing lots of extra nodes before finding it. 
Implement with iterative algorithm, use queue,
s.t.: {root, child-a, child-b, grandchild-a1, grandchild-b1, etc.}.
*/



/*
Hash Table 
Data structure that matches keys to values

Insert: O(1)
Search: O(1)
Remove: O(1)
[IN WORST CASE(i.e. bad hash function): O(n)]
*/
Hashtable<Object, Object> ht = new Hashtable<Object, Object>();

// Common Commands //
ht.put(key, value);  //inserts into table
ht.keys();	//shows all keys in table
ht.get(Object key);	//returns value associated with key
ht.containsKey(); 	//true if key equal to key within table (same for 
					// containsValue)
ht.remove(Object key); 	// remove key and its value
ht.clear();	//resets hashtable
ht.size(); 	//number of entries in table

// Hashtable implemented without class //
public class Node{
	int key;
	String value;
	Node next;
	Node(String value, int key){
		this.key = key;
		this.value = value;
		next = null;
	}
}

public class Hashtable{
	public int SIZE;
	public Node[] table;
	Hashtable(int num_elements){
		this.SIZE = num_elements;
		table = new Node[SIZE];
	}

	public int hash(String val){
		//works, too easy
		//return val.hashCode();

		int tot = 0;
		for(int i = 0; i < val.length(); i++){
			tot = val.charAt(i) * Math.pow(31, val.length()-1-i);
		}
	}

	public void insert(String val){
		int key = hash(val);
		Node n = new Node(key, val);
		int bucket = key % SIZE;
		Node head = table[bucket];
		//check if key already present
		while(head != null){
			if(head.key.equals(key)){
				head.value = val;
				return;
			}
			head = head.next;
		}
		//insert key into chain at end
		head.next = n;
		//OR to insert at beginning
		head = table[bucket];
		n.next = head;
		table[bucket] = n;
	}

	public String get(int key){
		int bucket = key % SIZE;
		Node head = table[bucket];
		while(head != null){
			if(head.key.equals(key)){
				return head.value;
			}
			head = head.next;
		}
	}

	public String remove(int key){
		int bucket = key % SIZE;
		Node head = table[bucket];
		Node prev = null;
		while(head != null){
			if(head.key.equals(key)){
				break;
			} else {
				prev = head;
				head = head.next;
			}
		}

		if (head == null){
			return null;
		}

		if (prev != null){
			prev.next = head.next;
		} else {
			table[bucket] = head.next;
		}
	}
}


/*
Heap 

Specialized tree, either min or max heap, where elements are always smaller  or greater than
	their child, respectively. The root is always the smallest or greatest node, respectively,
	then looking down the tree the elements always get bigger/ smaller.

How works:
Insertion: insert element in lowest, rightmost spot, then compare with parents, swapping it
	up the tree until it's in right spot
Remove min/ max: remove root, then swap value with last element added so it's now the root.
	This isn't in the right spot, so compare with children, swapping with smaller/ bigger of
	two until it's in the right spot.


Insert: O(log(n))
Remove min/ max: O(log(n))
*/
//Minimum heap
PriorityQueue<Integer> min_heap = new PriorityQueue<Integer> ();
//Maximum heap
PriorityQueue<Integer> max_heap = new PriorityQueue<Integer> () {
	public int compare(Integer a, Integer b) {
		return -1 * a.compareTo(b);
	}
}
//Minimum heap with own comparator
Comparator<String> comparator = new StringLengthComparator();
PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
// in file: StringLengthComparator.java
import java.util.Comparator;
public class StringLengthComparator implements Comparator<String>
{
    @Override
    public int compare(String x, String y)
    { return x.length() - y.length(); }
}


// Common Commands //
heap.add(Object element);  //inserts into table
heap.offer(Object element);  //same as add
heap.contains(Object element); //returns true if element is present
heap.remove(Object element); 	//removes single instance of element if present
heap.peek(); 	//retrieves but doesn't remove head of queue
heap.poll();	//retrieves and removes head of queue (returns null if empty)
heap.clear();	//removes all elements from collection
heap.size(); 	//number of elements in collection
heap.toArray(); //returns an array containing all elements in queue



/*
Linked List / Doubly Linked List
Ordered set of data elements, each containing a link to its successor
and in case of doubly linked list, also its predecessor.
http://www.geeksforgeeks.org/linked-list-set-1-introduction/

Insert: O(1)
Remove: O(1)
[if going to front of list, otherwise O(n)]
*/
LinkedList list = new LinkedList();

//Common Commands//
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

// Linked List without class //
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



/*
Queue
Linear data structure of flexible size, FIFO (First In First Out)

In Java, Queue does not directly have a data structure, but instead
you can write it as a LinkedList or Priority Queue. A linked list is
pretty standard queue implementation
*/
Queue queueA = new LinkedList();
Queue<Object> queueB = new LinkedList<Object>();

// Common Commands //
queue.add(); 	//adds element at tail (if LinkedList) or according
			 	//  to priortiy if (priority queue)
queue.peek(); 	//view head of queue w/o removing it. returns null if empty
queue.poll(); //removes and returns head of queue. returns nnull if empty

// Queue without class //




/*
Stack
Linear data structure of flexible size, LIFO (Last In First Out)

*/