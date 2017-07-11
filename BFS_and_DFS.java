/*
BREADTH FIRST SEARCH (BFS)
Algorithm that traverses graph or tree data strucutres. Starting at a given
node, explores all immediately neighboring nodes before moving to next 
level neighbors.
Implement with recursive algorithm, need some sort of is-visited flag.
*/

////////////////////////////
// EXAMPLE IMPLEMENTATION //
////////////////////////////

public void bfs(int[][] adjacency_matrix, Node node){
	Queue queue = new LinkedList();
	queue.add(node);
	node.visited = true;
	while(!queue.isEmpty){
		Node e = queue.remove();
		System.out.println(e.data + " ");
		Arraylist<Node> neighbors = findNeighbors(adjacency_matrix, e);
		for(Node n : neighbors){
			if(n != null && !n.visited){
				queue.add(n);
				n.visited = true;
			}

		}
	}
}



/*
DEPTH FIRST SEARCH (DFS)

Algorithm that traverses graph or tree data structure. Starting at a given
node, it explores as far as possible along each branch before backtracking.

Problem: can miss simple solutions, traversing lots of extra nodes before finding it. 
Implement with iterative algorithm, use queue,
s.t.: {root, child-a, child-b, grandchild-a1, grandchild-b1, etc.}.
*/


/////////////////////////////
// EXAMPLE IMPLEMENTATIONS //
/////////////////////////////

public void dfsUsingStack(int[][] adjacency_matrix, Node node){
	Stack stack = new Stack();
	stack.add(node);
	node.visited = true;
	while(!stack.isEmpty){
		Node e = stack.remove();
		System.out.println(e.data + " ");
		Arraylist<Node> neighbors = findNeighbors(adjacency_matrix, e);
		for(Node n : neighbors){
			if(n != null && !n.visited){
				stack.add(n);
				n.visited = true;
			}
		}
	}
}

public void dfsRecursive(int[][] adjacency_matrix, Node node){
	System.out.println(node.data + " ");
	Arraylist<Node> neighbors = findNeighbors(adjacency_matrix, node);
	for(Node n : neighbors){
		if(n != null && !n.visited){
			dfsRecursive(adjacency_matrix, n);
			n.visited = true;
		}
	}

}