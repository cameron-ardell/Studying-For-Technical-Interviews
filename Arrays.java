/*
ARRAYS

Fixed-size sequential collection of elements of same type
*/


/*
// Big O //

Insert: O(1)
Search: O(n OR log(n) OR n^2)
Remove: O(1) <-- ??
*/


///////////////////////
// Implementation(s) //
///////////////////////

Object[] array = new array[size];
double[] myList = {1.9, 2.9, 3.4, 3.5};


/////////////////////
// Common Commands //
/////////////////////

Arrays.binarySearch(Object[] a, Object key); // returns index if found, or the negative of where it should be inserted if not in array
Arrays.equals(Primitive_Object[] a, Primitive_Object[] b);	// returns true if two arrays have same # elements
															// and corresponding pairs match
Arrays.fill(Primitive_Object[] a, Primitive_Object val); // populate array with a value, returns nothing
Arrays.sort(Primitive_Object[] a); //sorts in ascending order, returns nothing