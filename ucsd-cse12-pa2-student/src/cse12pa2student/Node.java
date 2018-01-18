package cse12pa2student;

/* DO NOT MODIFY */

public class Node<E> {
	E value;
	//successor and previous nodes
	Node<E> succ, prev;
	public Node(E value, Node<E> succ, Node<E> prev) {
		this.value = value;
		this.succ = succ;
		this.prev = prev;
	}
}
