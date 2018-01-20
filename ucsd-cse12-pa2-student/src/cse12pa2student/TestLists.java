package cse12pa2student;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class TestLists {
	
	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Doubly-Linked"}, {"Array"} });
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
		switch(this.listType) {
			case "Doubly-Linked": return new CSE12DLList<E>();
			case "Array": return new CSE12ArrayList<E>();
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
		for (int i = 0; i < 26; i++){
			l.append((char)('a'+i)+"");
		}
		assertEquals(25, l.findFirst("z"));
		assertEquals(2, l.findFirst("c"));
	}
	
	@Test
	public void removeFirst() {
		CSE12List<String> l = makeList();
		for (int i = 0; i < 26; i++){
			l.append((char)('a'+i)+"");
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
		for (int i = 0; i < 26; i++){
			l.append((char)('a'+i)+"");
		}
		assertEquals(26, l.size());
		
	}
}

