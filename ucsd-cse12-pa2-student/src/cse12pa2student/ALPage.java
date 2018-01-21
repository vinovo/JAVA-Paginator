package cse12pa2student;

public class ALPage<E> implements Page<E> {

	/** TODO **/
	CSE12ArrayList<E> list;
	int cursor;

	public ALPage() {
		cursor = -1;
		list = new CSE12ArrayList<E>();
	}

	public E next() {
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

	public void fillList(CSE12ArrayList<E> ls) {
		this.list = ls;
	}
}
