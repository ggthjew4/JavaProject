package com.bluetechnology.test.generices;

import java.util.EnumSet;
import java.util.Set;
import static com.bluetechnology.test.generices.WaterColors.*;

public class WatercolorSets {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Set<WaterColors> set1 = EnumSet.range(EINC, DEEP_YELLOW);
        Set<WaterColors> set2 = EnumSet.range(DEEP_YELLOW, MEGENATA);
        Set<WaterColors> result = Sets.intersection(set1, set2);
        System.out.println(result);
	}
}
