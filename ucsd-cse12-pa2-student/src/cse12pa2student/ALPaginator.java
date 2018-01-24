package cse12pa2student;

import java.util.NoSuchElementException;

public class ALPaginator<T> extends Paginator<T> {

	/** TODO **/
	CSE12ArrayList<T> lst;
	int cursor, pgNums, perPage;

	/**
	 * the constructor of ALPaginator class
	 * @param perPage the numbers of elements per page
	 * @param size the total numbers of elements
	 */
	public ALPaginator(CSE12ArrayList<T> list, int perPage) {
		lst = list;
		this.perPage = perPage;
		if (lst.size() % this.perPage == 0)
			pgNums = lst.size() / this.perPage;
		else
			pgNums = lst.size() / this.perPage + 1;
		int cursor = 0;
		int curIndex = 0;
	}

	/**
	 * Return true if the iterator can traverse backward
	 * @return true if the iterator can traverse backward, false otherwise
	 */
	public boolean hasPrevious() {
		if (cursor >= 1 && cursor <= pgNums)
			return true;
		return false;
	}

	/**
	 * return the previous page
	 * @return the previous page
	 */
	public Page<T> previous() {
		if (!hasPrevious())
			throw new NoSuchElementException("cursor out of bounds");
		else {
			cursor--;
			int startIndex = cursor * perPage;
			int endIndex = (cursor + 1) * perPage - 1;
			if (endIndex >= lst.size())
				endIndex = lst.size() - 1;	
			ALPage<T> pg = new ALPage<T>(startIndex, endIndex, lst);
			return pg;
		}
	}

	/**
	 * return the next page
	 * @return the next page
	 */
	public Page<T> next() {
		if (!hasNext())
			throw new NoSuchElementException("cursor out of bounds");
		else {
			int startIndex = cursor * perPage;
			int endIndex = (cursor + 1) * perPage - 1;
			if (endIndex >= lst.size())
				endIndex = lst.size() - 1;	
			ALPage<T> pg = new ALPage<T>(startIndex, endIndex, lst);
			cursor++;
			return pg;
		}
	}

	/**
	 * return the index of the next page
	 * @return the index of the next page
	 */
	public int nextIndex() {
		if (cursor >= pgNums)
			throw new NoSuchElementException("cursor out of bounds");
		return cursor;
	}

	/**
	 * return the index of the previous page
	 * @return the index of the previous page
	 */
	public int previousIndex() {
		if (cursor < 1)
			throw new NoSuchElementException("cursor out of bounds");
		return cursor - 1;
	}

	/**
	 * return true if the iterator can traverse forward
	 * @return true if the iterator can traverse forward, false otherwise
	 */
	public boolean hasNext() {
		if (cursor >= 0 && cursor < pgNums)
			return true;
		return false;
	}
}
