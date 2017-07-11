/*
HASH TABLE

Data structure that matches keys to values
*/


/*
// Big O //

Insert: O(1)
Search: O(1)
Remove: O(1)
[IN WORST CASE(i.e. bad hash function): O(n)]
*/

///////////////////////
// Implementation(s) //
///////////////////////

Hashtable<Object, Object> ht = new Hashtable<Object, Object>();


/////////////////////
// Common Commands //
/////////////////////

ht.put(key, value);  //inserts into table
ht.keys();	//shows all keys in table
ht.get(Object key);	//returns value associated with key
ht.containsKey(); 	//true if key equal to key within table (same for 
					// containsValue)
ht.remove(Object key); 	// remove key and its value
ht.clear();	//resets hashtable
ht.size(); 	//number of entries in table



/////////////////////////////////////////
// Hashtable implemented without class //
/////////////////////////////////////////

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