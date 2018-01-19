package cse12pa2student;

public class CSE12DLList<E> implements CSE12List<E> {

	private Node<E> head, tail;
	private int size;

	public CSE12DLList() {
		this.head = new Node<E>(null, null, null);
		this.tail = new Node<E>(null, null, this.head);
		this.head.succ = tail;
		this.tail.prev = head;
	}

	@Override
	public void append(E e) {
		this.size += 1;
		Node<E> n = new Node<E>(e, this.tail, this.tail.prev);
		this.tail.prev.succ = n;
		this.tail.prev = n;
	}

	@Override
	public void prepend(E e) {
		this.size += 1;
		Node<E> n = new Node<E>(e, this.head.succ, this.head);
		this.head.succ.prev = n;
		this.head.succ = n;
	}

	@Override
	public void empty() {
		this.head = new Node<E>(null, null, null);
		this.tail = this.head;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public E getAt(int index) {
		if (index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
		}
		Node<E> curr = head.succ;
		while (index > 0 && curr.value != null) {
			curr = curr.succ;
			index -= 1;
		}
		return curr.value;
	}

	@Override
	public Paginator<E> paginate(int perPage) {
		/** TODO **/
		return null;
	}

	@Override
	public void removeFirst(E e) {
		/** TODO **/
		Node<E> curNode = head;
		if (getAt(0).equals(e)) {
			head.succ.prev = null;
			head = head.succ;
			size--;
			return;
		}
		if (getAt(this.size-1).equals(e)){
			tail.prev.succ = null;
			tail = tail.prev;
			size--;
			return;
		}
		for (int i = 0; i < this.size; i++) {
			if (getAt(i).equals(e)) {
				curNode.prev.succ = curNode.succ;
				curNode.succ.prev = curNode.prev;
				this.size--;
				return;
			} else {
				curNode = curNode.succ;
			}
		}
	}

	@Override
	public int findFirst(E e) {
		/** TODO **/
		for (int i = 0; i < this.size; i++) {
			if (getAt(i).equals(e))
				return i;
		}
		return -1;
	}

}
