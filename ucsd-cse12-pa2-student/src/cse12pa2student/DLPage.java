package cse12pa2student;

import java.util.NoSuchElementException;

public class DLPage<T> implements Page<T> {

	/** TODO **/
	CSE12DLList<T> lst;
	int cursor,start,end;

	/**
	 * the constructor of ALPage
	 */
	public DLPage(int startIndex, int endIndex, CSE12DLList<T> list) {
		lst = list;
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
		T t = lst.getAt(cursor);
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
