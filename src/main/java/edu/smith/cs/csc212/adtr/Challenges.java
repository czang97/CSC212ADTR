package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

/**
 * These are static method that work on SetADT and MapADT.
 * 
 * @author Crystal && Yifan
 *
 */
public class Challenges {

	// Union the two sets by addition.

	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String e : left) {
			output.insert(e);
		}
		for (String e : right) {
			output.insert(e);
		}
		return output;
	}

	// Finding intersection of the two sets.

	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();

		// Identifying the smaller set
		if (left.size() >= right.size()) {
			// Find repeated items across two set.
			for (String e : right) {
				if (left.contains(e)) {
					output.insert(e);
				}
			}
		} else {
			for (String e : left) {
				if (right.contains(e)) {
					output.insert(e);
				}
			}
		}
		return output;
	}

	// Count words from a list and output a map with the word and its count.

	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();

		for (String item : words) {
			Integer before = output.get(item);
			// When the word appear for the first time.
			if (before == null) {
				output.put(item, 1);

			} else {
				// When the word shows after the first time.
				output.put(item, before + 1);
			}

		}
		return output;

	}
}
