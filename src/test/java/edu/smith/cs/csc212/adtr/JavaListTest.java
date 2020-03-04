package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class JavaListTest {

	/**
	 * Make a new empty list.
	 * 
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}

	/**
	 * Helper method to make a full list.
	 * 
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}

	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}

	@Test(expected = EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}

	@Test(expected = EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}

	@Test(expected = EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}


	// add back
	@Test
	public void testAddToBack() {
		ListADT<String> data = makeFullList();
		data.addBack("z");
		assertEquals("z", data.getIndex(4));
		assertEquals(5, data.size());
	}

	// add back
	@Test
	public void testAddToBackMultiple() {
		ListADT<String> data = makeFullList();
		data.addBack("z");
		data.addBack("z");
		assertEquals(6, data.size());
	}

	// test list remove
	@Test
	public void testRemoveBack() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		assertEquals("c", data.getBack());
		assertEquals(3, data.size());
	}

	@Test
	public void testRemoveIndex() {
		ListADT<String> data = makeFullList();
		data.removeIndex(0);
		assertEquals("b", data.getFront());
		assertEquals(3, data.size());
	}

	@Test
	public void testRemoveFront() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		assertEquals("b", data.getFront());
		assertEquals(3, data.size());
	}

	// test addIndex methods.

	// add Back by index
	@Test
	public void testaddIndexFront() {
		ListADT<String> data = makeFullList();
		data.addIndex(0, "z");
		assertEquals(5, data.size());
		assertEquals("z", data.getFront());
	}

	// add Back by index
	@Test
	public void testaddIndexMiddle() {
		ListADT<String> data = makeFullList();
		data.addIndex(1, "z");
		assertEquals("a", data.getFront());
		assertEquals("z", data.getIndex(1));
		assertEquals("b", data.getIndex(2));
	}

	// add Back by index
	@Test
	public void testaddIndexBack() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size(), "z");
		assertEquals("z", data.getBack());
	}

	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}

	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}

	@Test(expected = EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}

	@Test(expected = EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}

	@Test(expected = BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}

	@Test(expected = BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}

	@Test(expected = BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size() * 2);
	}

	@Test(expected = BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size() * 2, "the");
	}

	@Test(expected = BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size() + 1, "the");
	}

	@Test(expected = BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}

	// set index
	@Test
	public void testsetIndexFront() {
		ListADT<String> data = makeFullList();
		data.setIndex(0, "z");
		assertEquals("z", data.getFront());
	}

	// set index
	@Test
	public void testsetIndexBack() {
		ListADT<String> data = makeFullList();
		data.setIndex(data.size()-1, "z");
		assertEquals(4, data.size());
		assertEquals("z", data.getBack());
	}

	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}

	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}

	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
