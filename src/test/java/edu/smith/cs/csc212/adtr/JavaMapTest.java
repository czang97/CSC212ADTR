package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// You might want this; if you're using Map<String, Integer> anywhere...
	// JUnit has an assertEquals(Object, Object) and an assertEquals(int, int).
	// When you give it assertEquals(Integer, int) it doesn't know which to use (but both would be OK!)
	// This method gets around that by forcing the (int, int) version.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	//Yifan
	@Test
	public void testInfinite() {
		MapADT<Integer, String> aMap = new JavaMap<>();
		for (int i = 0; i<1000000; i++) {
			aMap.put(i, "Student");
		}
		assertEquals(aMap.size(),1000000);
	}
	
	//Yifan
	//test put
	@Test
	public void testPut() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.put("Crystal", "Student");
		 aMap.put("JJ", "Professor");
		assertEquals(aMap.size(),3);
	}
	
	
	//Yifan
	//test put  
	@Test
	public void testPutUnique() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.put("Crystal", "Student");
		 aMap.put("JJ", "Professor");
		 aMap.put("Crystal", "Professor");
		assertEquals("Professor", aMap.get("Crystal"));
	}
	
	//Crystal
	//test put  
	@Test
	public void testPutNull() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.put("Crystal", "Student");
		 aMap.put(null, "Professor");
		 assertEquals(aMap.size(), 3);
	}
	
	
	//Crystal
	//test get
	@Test
	public void testGet() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.put("Crystal", "Student");
		 assertEquals("Student", aMap.get("Crystal"));
	}
	
	
	//Crystal
	//test get
	@Test
	public void testGetValue() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.put("Crystal", "Student");
		 assertEquals(null, aMap.get("Student"));
	}
	
	
	//Crystal
	@Test
	public void testRemove() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.remove("Yifan");
		 assertEquals(0, aMap.size());
	}
	
	//Yifan
	@Test
	public void testRemoveempty() {
		MapADT<String, String> aMap = new JavaMap<>();
		 aMap.put("Yifan", "Student");
		 aMap.remove("Crystal");
		 assertEquals(1, aMap.size());
	}
	
}
