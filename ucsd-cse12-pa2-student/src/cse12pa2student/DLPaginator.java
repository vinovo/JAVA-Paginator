package cse12pa2student;

public class DLPaginator<E> extends Paginator<E> {

	/** TODO **/
	DLPage<E>[] list;
	int cursor, pgNums;

	/**
	 * the constructor of ALPaginator class
	 * @param perPage the numbers of elements per page
	 * @param size the total numbers of elements
	 */
	public DLPaginator(int perPage, int size) {
		cursor = -1;
		if (size % perPage == 0)
			pgNums = size / perPage;
		else
			pgNums = size / perPage + 1;
		list = new DLPage[pgNums];
		for (int i = 0; i < pgNums; i++) {
			list[i] = new DLPage<E>();
		}
	}

	/**
	 * Return true if the iterator can traverse backward
	 * @return true if the iterator can traverse backward, false otherwise
	 */
	public boolean hasPrevious() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		if (cursor >= 0 && list[cursor] != null)
			return true;
		return false;
	}

	/**
	 * return the previous page
	 * @return the previous page
	 */
	public Page<E> previous() {
		if (cursor < 0 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		else {
			cursor--;
			DLPage<E> page = new DLPage<E>();
			page.list = list[cursor + 1].list;
			list[cursor + 1] = page;
			return list[cursor + 1];
		}
	}

	/**
	 * return the next page
	 * @return the next page
	 */
	public Page<E> next() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		else {
			cursor++;
			DLPage<E> page = new DLPage<E>();
			page.list = list[cursor].list;
			list[cursor] = page;
			return list[cursor];
		}
	}

	/**
	 * return the index of the next page
	 * @return the index of the next page
	 */
	public int nextIndex() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		return cursor + 1;
	}

	/**
	 * return the index of the previous page
	 * @return the index of the previous page
	 */
	public int previousIndex() {
		if (cursor < 0 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		return cursor;
	}

	/**
	 * return true if the iterator can traverse forward
	 * @return true if the iterator can traverse forward, false otherwise
	 */
	public boolean hasNext() {
		if (cursor < -1 || cursor >= pgNums)
			throw new ArrayIndexOutOfBoundsException("cursor out of bounds");
		if (cursor < pgNums - 1 && list[cursor + 1] != null)
			return true;
		return false;
	}

}
