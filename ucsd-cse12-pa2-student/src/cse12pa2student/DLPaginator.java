package cse12pa2student;

import java.util.NoSuchElementException;

public class DLPaginator<E> extends Paginator<E> {

	/** TODO **/
	Node<E> node;
	int cursor, pgNums, perPage, size;

	/**
	 * the constructor of DLPaginator class
	 * 
	 * @param perPage
	 *            the numbers of elements per page
	 * @param size
	 *            the total numbers of elements
	 */
	public DLPaginator(int size, int perPage, Node<E> head) {
		this.size = size;
		this.perPage = perPage;
		if (this.size % this.perPage == 0)
			pgNums = this.size / this.perPage;
		else
			pgNums = this.size / this.perPage + 1;
		cursor = 0;
		node = head;
	}

	/**
	 * Return true if the iterator can traverse backward
	 * 
	 * @return true if the iterator can traverse backward, false otherwise
	 */
	public boolean hasPrevious() {
		if (cursor >= 1 && cursor <= pgNums)
			return true;
		return false;
	}

	/**
	 * return the previous page
	 * 
	 * @return the previous page
	 */
	public Page<E> previous() {
		if (!hasPrevious())
			throw new NoSuchElementException("cursor out of bounds");
		else {
			cursor--;
			int startIndex = cursor * perPage;
			int endIndex = (cursor + 1) * perPage - 1;
			if (endIndex >= size)
				endIndex = size - 1;
			for (int i = 0; i < startIndex; i++){
				node = node.succ;
			}
			DLPage<E> pg = new DLPage<E>(startIndex, endIndex, node);
			while (node.prev != null){
				node = node.prev;
			}
			return pg;
		}
	}

	/**
	 * return the next page
	 * 
	 * @return the next page
	 */
	public Page<E> next() {
		if (!hasNext())
			throw new NoSuchElementException("cursor out of bounds");
		else {
			int startIndex = cursor * perPage;
			int endIndex = (cursor + 1) * perPage - 1;
			if (endIndex >= size)
				endIndex = size - 1;
			for (int i = 0; i < startIndex; i++){
				node = node.succ;
			}
			DLPage<E> pg = new DLPage<E>(startIndex, endIndex, node);
			cursor++;
			while (node.prev != null){
				node = node.prev;
			}
			return pg;
		}
	}

	/**
	 * return the index of the next page
	 * 
	 * @return the index of the next page
	 */
	public int nextIndex() {
		if (cursor >= pgNums)
			throw new NoSuchElementException("cursor out of bounds");
		return cursor;
	}

	/**
	 * return the index of the previous page
	 * 
	 * @return the index of the previous page
	 */
	public int previousIndex() {
		if (cursor < 1)
			throw new NoSuchElementException("cursor out of bounds");
		return cursor - 1;
	}

	/**
	 * return true if the iterator can traverse forward
	 * 
	 * @return true if the iterator can traverse forward, false otherwise
	 */
	public boolean hasNext() {
		if (cursor >= 0 && cursor < pgNums)
			return true;
		return false;
	}

}
