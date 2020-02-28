package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {

	// test size
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}

	// test size
	@Test
	public void testInfinity() {
		SetADT<Integer> empty = new JavaSet<>();
		for (int i = 0; i < 100000; i++) {
			empty.insert(i);
		}
		assertEquals(empty.size(), 100000);
	}

	// test insert
	// Crystal typed
	@Test
	public void testInsert() {
		SetADT<String> aSet = new JavaSet<>();
		aSet.insert("Yifan");
		aSet.insert("Crystal");
		assertEquals(aSet.size(), 2);
	}

	// test insert
	// Yifan typed
	@Test
	public void testInsertMultiple() {
		SetADT<String> aSet = new JavaSet<>();
		aSet.insert("Yifan");
		aSet.insert("Crystal");
		aSet.insert("Crystal");
		assertEquals(aSet.size(), 2);
	}

	// test contains
	// Crystal typed
	@Test
	public void testContainExist() {
		SetADT<String> aSet = new JavaSet<>();
		aSet.insert("Yifan");
		aSet.remove("Yifan");
		assertFalse(aSet.contains("Yifan"));
	}

	// test contains
	// Yifan typed
	@Test
	public void testContainNotExist() {
		SetADT<String> aSet = new JavaSet<>();
		aSet.insert("Yifan");
		aSet.insert("Crystal");
		assertTrue(aSet.contains("Yifan"));
		assertTrue(aSet.contains("Crystal"));
	}

	// test remove
	// Crystal
	@Test
	public void testremovenull() {
		SetADT<String> aSet = new JavaSet<>();
		aSet.insert("Crystal");
		aSet.remove("Yifan");
		// assertEquals(aSet.remove("Yifan"));
		assertEquals(aSet.size(), 1);

	}

	// test remove
	// Yifan
	@Test
	public void testremove() {
		SetADT<String> aSet = new JavaSet<>();
		aSet.insert("Crystal");
		aSet.remove("Crystal");
		assertEquals(aSet.size(), 0);
	}

}
