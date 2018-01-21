package cse12pa2student;

/* DO NOT MODIFY */

public interface CSE12List<E> {

	/*
	 * Adds e at the end of the list, leaving indices for existing elements
	 * unchanged
	 */
	void append(E e);

	/*
	 * Adds e at index 0, shifting all other elements up one index
	 */
	void prepend(E e);

	/*
	 * Returns the element at the given index, or throws
	 * IndexOutOfBoundsException if index is not in range
	 */
	E getAt(int index);

	/*
	 * Removes all element from the list
	 */
	void empty();

	/*
	 * Returns the size of the list
	 */
	int size();

	/*
	 * Returns a paginator that produces pages iterating over pePage elements at
	 * a time
	 */
	Paginator<E> paginate(int perPage);

	/*
	 * Removes the first element that is .equals(e)
	 * 
	 * Has no effect if no such element is present
	 */
	void removeFirst(E e);

	/*
	 * Returns the first index where an element of the list is .equals(e)
	 * 
	 * If no such element is present, returns -1
	 */
	int findFirst(E e);

}
