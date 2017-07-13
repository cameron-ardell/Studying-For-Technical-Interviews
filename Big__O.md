# Big O 

### How the run time scales with respect to some input variables.


Linear: O(N) [where N is the size of the array]

boolean contains(array, x){
	for each element in array {
		if element == x {
			return true;
		}
	}
}

Quadratic: O(N^2)

void printPairs(array){
	for each x in array {
		for each y in array {
			print x, y
		}
	}
}


## KEY RULES 

#### 1) Different steps get added
i.e.

	// run time is O(a+b)
	function something(){
		doStep1(); // O(a)
		doStep2(); // O(b)
	}

#### 2) Drop constants
i.e.

	// run time is O(n)
	function minMax1(array){
		min, max = NULL
		for each e in array:  // O(n)
			min = MIN(e, min)
		for each e in array:  // O(n)
			max = MAX(e, max)
	}

	// run time is O(n)
	function minMax1(array){
		min, max = NULL
		for each e in array:  // O(n)
			min = MIN(e, min)
			max = MAX(e, max)
	}

#### 3) Different inputs, use different variables for them
i.e.

	// run time is O(a*b)
	int intersectionSize(array A, array B){
		int count = 0
		for a in A{
			for b in B{
				if a==b{
					count = count + 1
				}
			}
		}
		return count
	}

#### 4) Drop non-dominant terms
i.e. 

	// run time is O(n^2)
	function whyWouldIdoThis(array A){
		max = NULL
		for each a in A {  // O(n)
			max = MAX(a, max)
		}
		print max
		for each a in A {	// O(n^2)
			for each b in A {
				print a, b
			}
		}
	}