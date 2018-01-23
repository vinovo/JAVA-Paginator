package cse12pa2student;

public class ALPage<E> implements Page<E> {

	/** TODO **/
	E[] list;
	int cursor;

	/**
	 * the constructor of ALPage
	 */
	public ALPage() {
		cursor = -1;
	}

	/**
	 * return the next element of current page
	 * @return the next element of current page
	 */
	public E next() {
		if (cursor < -1 || cursor + 1 >= list.length)
			throw new IndexOutOfBoundsException("cursor out of bounds");
		cursor++;
		return list[cursor];
	}

	/**
	 * @return true if there's still element untouched in the current page,
	 *         false otherwise
	 */
	public boolean hasNext() {
		if (cursor < -1 || cursor > list.length)
			throw new IndexOutOfBoundsException("cursor out of bounds");
		if (cursor + 1 < list.length && list[cursor+1] != null)
			return true;
		return false;
	}

}
