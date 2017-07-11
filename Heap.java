/*
HEAP

Specialized tree, either min or max heap, where elements are always smaller  or greater than
	their child, respectively. The root is always the smallest or greatest node, respectively,
	then looking down the tree the elements always get bigger/ smaller.

How works:
Insertion: insert element in lowest, rightmost spot, then compare with parents, swapping it
	up the tree until it's in right spot
Remove min/ max: remove root, then swap value with last element added so it's now the root.
	This isn't in the right spot, so compare with children, swapping with smaller/ bigger of
	two until it's in the right spot.
*/

/*
// Big O //	

Insert: O(log(n))
Remove min/ max: O(log(n))
*/


///////////////////////
// Implementation(s) //
///////////////////////

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



/////////////////////
// Common Commands //
/////////////////////

heap.add(Object element);  //inserts into table
heap.offer(Object element);  //same as add
heap.contains(Object element); //returns true if element is present
heap.remove(Object element); 	//removes single instance of element if present
heap.peek(); 	//retrieves but doesn't remove head of queue
heap.poll();	//retrieves and removes head of queue (returns null if empty)
heap.clear();	//removes all elements from collection
heap.size(); 	//number of elements in collection
heap.toArray(); //returns an array containing all elements in queue