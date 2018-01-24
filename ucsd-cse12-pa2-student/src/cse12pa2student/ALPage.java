package cse12pa2student;

import java.util.NoSuchElementException;

public class ALPage<E> implements Page<E> {

	/** TODO **/
	CSE12ArrayList<E> lst;
	int cursor,start,end;

	/**
	 * the constructor of ALPage
	 */
	public ALPage(int startIndex, int endIndex, CSE12ArrayList<E> list) {
		lst = list;
		cursor = startIndex;
		start = startIndex;
		end = endIndex;
	}

	/**
	 * return the next element of current page
	 * @return the next element of current page
	 */
	public E next() {
		if (!hasNext())
			throw new NoSuchElementException("cursor out of bounds");
		E t = lst.getAt(cursor);
		cursor++;
		return t;
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
