package cse12pa2student;

public class ALPaginator<T> extends Paginator<T> {

	/** TODO **/
	ALPage<T>[] list;
	int cursor, pgNums;

	public ALPaginator(int perPage, int size) {
		cursor = -1;
		if (size % perPage == 0)
			pgNums = size / perPage;
		else
			pgNums = size / perPage + 1;
		list = new ALPage[pgNums];
		for (int i = 0; i < pgNums; i++) {
			list[i] = new ALPage<T>();
		}
	}

	public boolean hasPrevious() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		if (cursor >= 0 && list[cursor] != null)
			return true;
		return false;
	}

	public Page<T> previous() {
		if (cursor < 0 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		else {
			cursor--;
			ALPage<T> page = new ALPage<T>();
			page.list = list[cursor + 1].list;
			list[cursor + 1] = page;
			return list[cursor + 1];
		}
	}

	public Page<T> next() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		else {
			cursor++;
			ALPage<T> page = new ALPage<T>();
			page.list = list[cursor].list;
			list[cursor] = page;
			return list[cursor];
		}
	}

	public int nextIndex() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		return cursor + 1;
	}

	public int previousIndex() {
		if (cursor < 0 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		return cursor;
	}

	public boolean hasNext() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		if (cursor < pgNums - 1 && list[cursor + 1] != null)
			return true;
		return false;
	}

}
