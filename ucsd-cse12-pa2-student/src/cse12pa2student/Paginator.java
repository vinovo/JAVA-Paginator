package cse12pa2student;

/* DO NOT MODIFY */

import java.util.ListIterator;

abstract class Paginator<E> implements ListIterator<Page<E>> {
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Skip this for PA2");
	}

	@Override
	public void set(Page<E> e) {
		throw new UnsupportedOperationException("Skip this for PA2");
	}

	@Override
	public void add(Page<E> e) {
		throw new UnsupportedOperationException("Skip this for PA2");
	}
}
