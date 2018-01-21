package cse12pa2student;

public class DLPage<T> implements Page<T> {

	/** TODO **/
	CSE12DLList<T> list;
	int cursor;

	public DLPage() {
		cursor = -1;
		list = new CSE12DLList<T>();
	}

	public T next() {
		if (cursor < -1 || cursor + 1 >= list.size())
			throw new IndexOutOfBoundsException("cursor out of bounds");
		cursor++;
		return list.getAt(cursor);
	}

	public boolean hasNext() {
		if (cursor < -1 || cursor > list.size())
			throw new IndexOutOfBoundsException("cursor out of bounds");
		if (cursor + 1 < list.size() && list.getAt(cursor + 1) != null)
			return true;
		return false;
	}
}
