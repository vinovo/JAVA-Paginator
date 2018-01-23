package cse12pa2student;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS = Arrays.asList(new Object[][] { { "Doubly-Linked" }, { "Array" } });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> CSE12List<E> makeList() {
		switch (this.listType) {
		case "Doubly-Linked":
			return new CSE12DLList<E>();
		case "Array":
			return new CSE12ArrayList<E>();
		}
		return null;
	}

	/* Example Tests */
	@Test
	public void testEmpty() {
		CSE12List<String> l = makeList();
		assertEquals(0, l.size());
	}

	@Test
	public void addAndGet() {
		CSE12List<String> l = makeList();
		l.append("a");
		assertEquals("a", l.getAt(0));
	}

	@Test
	public void findFirst() {
		CSE12List<String> l = makeList();
		for (int i = 0; i < 26; i++) {
			l.append((char) ('a' + i) + "");
		}
		assertEquals(25, l.findFirst("z"));
		assertEquals(2, l.findFirst("c"));
	}

	@Test
	public void removeFirst() {
		CSE12List<String> l = makeList();
		for (int i = 0; i < 26; i++) {
			l.append((char) ('a' + i) + "");
		}
		l.removeFirst("a");
		assertEquals(25, l.size());
		l.removeFirst("d");
		assertEquals(24, l.size());
		l.removeFirst("z");
		assertEquals(23, l.size());
		assertEquals("b", l.getAt(0));
		assertEquals("c", l.getAt(1));
		assertEquals("e", l.getAt(2));
		assertEquals("y", l.getAt(22));
	}

	@Test
	public void testSize() {
		CSE12List<String> l = makeList();
		for (int i = 0; i < 26; i++) {
			l.append((char) ('a' + i) + "");
		}
		assertEquals(26, l.size());

	}

	@Test
	public void testALPaginator() {
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");

		Paginator<String> p = lst.paginate(2);

		Page<String> p1 = p.next();
		assertEquals("a", p1.next());
		assertEquals("b", p1.next());

		Page<String> p2 = p.next();
		assertEquals("c", p2.next());
		assertEquals("d", p2.next());

		Page<String> p3 = p.next();
		assertEquals("e", p3.next());
		assertFalse(p3.hasNext());

		assertFalse(p.hasNext());
		assertTrue(p.hasPrevious());

		Page<String> p3Again = p.previous();
		Page<String> p2Again = p.previous();

		assertFalse(p2.hasNext());
		assertFalse(p3.hasNext());

		assertEquals("e", p3Again.next());
		assertFalse(p3Again.hasNext());

		assertEquals("c", p2Again.next());
		assertEquals("d", p2Again.next());

		assertTrue(p.hasNext());
	}
	
	@Test
	public void size1HasPrevious(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		Paginator<String> p = lst.paginate(1);
		
		assertFalse(p.hasPrevious());
		Page<String> p1 = p.next();
		assertTrue(p.hasPrevious());
		assertTrue(p1.hasNext());
		p1.next();
		assertFalse(p1.hasNext());
	}
	
	@Test
	public void noexns(){
		CSE12List<String> lst = makeList();
		Paginator<String> p = lst.paginate(1);
		
		assertFalse(p.hasNext());
		assertFalse(p.hasPrevious());
	}
	
	@Test
	public void badhasNexthasPrev(){
		CSE12List<String> lst = makeList();	
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		Paginator<String> p = lst.paginate(2);
		assertFalse(p.hasPrevious());
		assertTrue(p.hasNext());
		p.next();
		assertTrue(p.hasPrevious());
		assertTrue(p.hasNext());
		p.next();
		assertTrue(p.hasPrevious());
		assertTrue(p.hasNext());
		p.next();
		assertTrue(p.hasPrevious());
		assertFalse(p.hasNext());
	}
	
	@Test
	public void removeAll(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		lst.empty();
		assertEquals(0, lst.size());
		Paginator<String> p = lst.paginate(1);
		assertFalse(p.hasPrevious());
		assertFalse(p.hasNext());
	}
	
	@Test
	public void findRemoveFail(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		lst.removeFirst("b");
		assertEquals(4,lst.size());
		assertEquals("c",lst.getAt(1));
		lst.removeFirst("d");
		assertEquals(3,lst.size());
		assertEquals("e",lst.getAt(2));
	}
	
	@Test
	public void failExactSizePerPage(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		Paginator<String> p = lst.paginate(5);
		assertTrue(p.hasNext());
		Page<String> p1 = p.next();
		p1.next();
		p1.next();
		p1.next();
		p1.next();
		p1.next();
		assertFalse(p1.hasNext());
		assertFalse(p.hasNext());
	}
	
	@Test
	public void notFoundFail(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		assertEquals(2,lst.findFirst("c"));
		assertEquals(-1,lst.findFirst("gg"));
	}
	
	@Test
	public void exactLast(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		Paginator<String> p = lst.paginate(1);
		Page<String> p1 = p.next();
		assertTrue(p.hasPrevious());
		assertFalse(p.hasNext());
		assertEquals("a", p1.next());
		assertFalse(p1.hasNext());
	}
	
	@Test
	public void size1_find(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		assertEquals(0,lst.findFirst("a"));
		assertEquals(-1,lst.findFirst("gg"));
	}
	
	@Test
	public void empty_findremovefail(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		lst.removeFirst("a");
		assertEquals(0, lst.size());
		assertEquals(-1,lst.findFirst("a"));
	}
	
	@Test
	public void DLListRemoveAll(){
		CSE12List<String> lst = makeList();
		lst.append("a");
		lst.append("b");
		lst.append("c");
		lst.append("d");
		lst.append("e");
		lst.removeFirst("gg");
		lst.removeFirst("a");
		lst.removeFirst("b");
		lst.removeFirst("c");
		lst.removeFirst("d");
		lst.removeFirst("e");
		assertEquals(0,lst.size());
		assertEquals(-1,lst.findFirst("c"));
	}
}
