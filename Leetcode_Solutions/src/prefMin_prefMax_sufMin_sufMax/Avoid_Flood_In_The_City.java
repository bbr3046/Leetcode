package prefMin_prefMax_sufMin_sufMax;

import java.util.TreeMap;
import java.util.TreeSet;

public class Avoid_Flood_In_The_City {

	public int[] avoidFlood(int[] rains) {

		int n = rains.length;
		int[] ans = new int[n];

		TreeMap<Integer, Integer> recentlyFilledDate = new TreeMap<>();
		TreeSet<Integer> drainDays = new TreeSet<>();

		for (int day = 0; day < n; day++) {

			if (rains[day] > 0 && recentlyFilledDate.get(rains[day]) == null) {
				ans[day] = -1;
				recentlyFilledDate.put(rains[day], day);
			}

			else if (rains[day] > 0 && recentlyFilledDate.get(rains[day]) != null) {
				Integer immediateDrainDay = drainDays.higher(recentlyFilledDate.get(rains[day]));
				if (immediateDrainDay != null) {
					ans[immediateDrainDay] = rains[day];
					ans[day] = -1;
					recentlyFilledDate.put(rains[day], day);
					drainDays.remove(immediateDrainDay);
				} else
					return new int[] {};
			}

			else
				drainDays.add(day);
		}

		return null;
	}

}
