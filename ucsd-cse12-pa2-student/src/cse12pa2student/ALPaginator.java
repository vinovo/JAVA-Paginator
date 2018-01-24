package cse12pa2student;

import java.util.NoSuchElementException;

public class ALPaginator<T> extends Paginator<T> {

	/** TODO **/
	ALPage<T>[] list;
	int cursor, pgNums;

	/**
	 * the constructor of ALPaginator class
	 * @param perPage the numbers of elements per page
	 * @param size the total numbers of elements
	 */
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
	public Page<T> previous() {
		if (cursor < 1 || cursor >= pgNums)
			throw new NoSuchElementException("cursor out of bounds");
		else {
			cursor--;
			ALPage<T> page = new ALPage<T>();
			page.list = list[cursor + 1].list;
			list[cursor + 1] = page;
			return list[cursor + 1];
		}
	}

	/**
	 * return the next page
	 * @return the next page
	 */
	public Page<T> next() {
		if (cursor < -1 || cursor >= pgNums - 1)
			throw new NoSuchElementException("cursor out of bounds");
		else {
			cursor++;
			ALPage<T> page = new ALPage<T>();
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
