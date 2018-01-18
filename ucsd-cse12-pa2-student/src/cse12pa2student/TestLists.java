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
}

