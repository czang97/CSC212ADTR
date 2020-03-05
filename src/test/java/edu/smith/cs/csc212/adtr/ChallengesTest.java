package edu.smith.cs.csc212.adtr;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class ChallengesTest {

	//test union
	//Crystal typed
	@Test
	public void testUnionSimple() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		right.insert("B");
		right.insert("C");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");
		expected.insert("C");
		Assert.assertEquals(expected, Challenges.union(left, right));
	}
	
	//Crystal typed
	@Test
	public void testUnionDisjoint() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		right.insert("C");
		right.insert("D");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");
		expected.insert("C");
		expected.insert("D");
		Assert.assertEquals(expected, Challenges.union(left, right));
	}
	
	//Crystal typed
	@Test
	public void testUnionNested() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		left.insert("C");
		right.insert("A");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");
		expected.insert("C");
		Assert.assertEquals(expected, Challenges.union(left, right));
	}
	
	//test intersect
	//Yifan tested
	@Test
	public void testIntersectionSimple() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		right.insert("B");
		right.insert("C");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("B");
		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}
	
	//Yifan tested
	@Test
	public void testingIntersectionNull() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		
		left.insert("A");
		left.insert("B");
		right.insert("C");
		right.insert("D");
		
		SetADT<String> expected = new JavaSet<>();
		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}
	
	//Yifan tested
	@Test
	public void testingIntersectionNullAll() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		SetADT<String> expected = new JavaSet<>();
		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}
	
	//Yifan tested
	@Test
	public void testingIntersectionNested() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		
		left.insert("A");
		left.insert("B");
		left.insert("C");
		right.insert("A");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}
	
	
	//test wordcount
	//Yifan tested
	@Test
	public void testWordCountSimple() {
		ListADT<String> example = new JavaList<>();
		for (String word : new String[] {"a", "b", "a", "b", "c", "d"}) {
			example.addBack(word);
		}
		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 2);
		expected.put("b", 2);
		expected.put("c", 1);
		expected.put("d", 1);
		
		Assert.assertEquals(expected, Challenges.wordCount(example));
	}
	
	//Crystal tested
	@Test
	public void testWordCountNull() {
		ListADT<String> example = new JavaList<>();
		for (String word : new String[] {"a", "b", "a", "b", "c"}) {
			example.addBack(word);
		}
		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 2);
		expected.put("b", 2);
		expected.put("c", 1);

		Assert.assertEquals(null, Challenges.wordCount(example).get("d"));
	}
}
