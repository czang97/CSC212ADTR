package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

// Wow, this class really needs some comments...
public class Challenges {

	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String e : left) {
			output.insert(e);
		}
		for (String e : right) {
			output.insert(e);
		}
		// System.out.println("Union output: " + output);
		return output;
	}

	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		if (left.size() >= right.size()) {
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

	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();

		for (String item : words) {
			Integer before = output.get(item); // int before = output.getEntries(item, 0);


			if (before == null) {
				output.put(item, 1);

			} else {
				output.put(item, before+1);
			}

		}
		return output;

	}
}
