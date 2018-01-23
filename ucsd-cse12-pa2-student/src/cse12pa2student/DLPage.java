package cse12pa2student;

public class DLPage<T> implements Page<T> {

	/** TODO **/
	T[] list;
	int cursor;

	public DLPage() {
		cursor = -1;
	}

	public T next() {
		if (cursor < -1 || cursor + 1 >= list.length)
			throw new IndexOutOfBoundsException("cursor out of bounds");
		cursor++;
		return list[cursor];
	}

	public boolean hasNext() {
		if (cursor < -1 || cursor > list.length)
			throw new IndexOutOfBoundsException("cursor out of bounds");
		if (cursor + 1 < list.length && list[cursor+1] != null)
			return true;
		return false;
	}
}
