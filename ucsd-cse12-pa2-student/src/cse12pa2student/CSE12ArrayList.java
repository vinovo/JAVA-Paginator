package cse12pa2student;

public class CSE12ArrayList<T> implements CSE12List<T> {

	private T[] contents;
	private int size;

	@SuppressWarnings(value = { "unchecked" })
	public CSE12ArrayList() {
		this.contents = (T[]) (new Object[10]);
	}

	@SuppressWarnings(value = { "unchecked" })
	private void expandCapacity(int targetSize) {
		if (this.contents.length < targetSize) {
			T[] newContents = (T[]) (new Object[this.contents.length * 2]);
			for (int i = 0; i < this.contents.length; i += 1) {
				newContents[i] = this.contents[i];
			}
			this.contents = newContents;
		}
	}

	@Override
	public void append(T e) {
		expandCapacity(this.size + 1);
		this.contents[this.size] = e;
		this.size += 1;
	}

	@Override
	public void prepend(T e) {
		expandCapacity(this.size + 1);
		for (int i = this.size - 1; i >= 0; i -= 1) {
			this.contents[i + 1] = this.contents[i];
		}
		this.contents[0] = e;
		this.size += 1;
	}

	@Override
	@SuppressWarnings(value = { "unchecked" })
	public void empty() {
		this.contents = (T[]) (new Object[10]);
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T getAt(int index) {
		if (index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
		}
		return this.contents[index];
	}

	@Override
	/**
	 * Create and return a paginator
	 * 
	 * @param perPage
	 *            the numbers of elements each page contains
	 * @return Paginator<T> the created paginator
	 */
	public Paginator<T> paginate(int perPage) {
		/** TODO **/
		ALPaginator<T> p = new ALPaginator(this.contents, perPage, this.size);
		return p;
	}

	/**
	 * Removes the first element that is .equals(e)
	 * 
	 * @param e
	 *            the element to be removed
	 */
	@Override
	public void removeFirst(T e) {
		/** TODO **/
		for (int i = 0; i < this.size; i++) {
			if (getAt(i).equals(e)) {
				for (int j = i; j < contents.length - 1; j++) {
					contents[j] = contents[j + 1];
				}
				expandCapacity(this.size - 1);
				this.size--;
				return;
			}
		}
	}

	/**
	 * Returns the first index where an element of the list is .equals(e)
	 * 
	 * @param e
	 *            the elements to be found
	 * @return the index of the found elements
	 */
	@Override
	public int findFirst(T e) {
		/** TODO **/
		for (int i = 0; i < this.size; i++) {
			if (getAt(i).equals(e))
				return i;
		}
		return -1;
	}

}
