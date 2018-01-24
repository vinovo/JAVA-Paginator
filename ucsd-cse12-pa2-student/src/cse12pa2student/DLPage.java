package cse12pa2student;

import java.util.NoSuchElementException;

public class DLPage<T> implements Page<T> {

	/** TODO **/
	Node<T> node;
	int cursor, start, end;

	/**
	 * the constructor of ALPage
	 */
	public DLPage(int startIndex, int endIndex, Node<T> node) {
		this.node = node;
		cursor = startIndex;
		start = startIndex;
		end = endIndex;
	}

	/**
	 * return the next element of current page
	 * 
	 * @return the next element of current page
	 */
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException("cursor out of bounds");
		node = node.succ;
		cursor++;
		return node.value;
	}

	/**
	 * @return true if there's still element untouched in the current page,
	 *         false otherwise
	 */
	public boolean hasNext() {
		if (cursor <= end)
			return true;
		return false;
	}
}
