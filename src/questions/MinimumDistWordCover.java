package questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistWordCover
{

	// Implementing here with two List<String>
	// Should be easy enough to use arrays, or streams, or whatever.
	public static int getShortestSubseqWith(List<String> text, List<String> words)
	{
		int minDistance = Integer.MAX_VALUE;
		// Create a map of the last known position of each word
		Map<String, Integer> map = new HashMap();
		for (String word : words)
		{
			map.put(word, -1);
		}
		String word;
		// One loop through the main search string
		for (int position = 0; position < text.size(); position++)
		{
			word = text.get(position);
			// If the current word found is in the list we're looking for
			if (map.containsKey(word))
			{
				// Update the map
				map.put(word, position);
				// And if the current positions are the closest seen so far,
				// update the min value.
				int curDistance = getCurDistance(map);
				if (curDistance < minDistance)
					minDistance = curDistance;
			}
		}
		return minDistance;
	}

	// Get the current distance between the last known position of each value in
	// the map
	private static int getCurDistance(Map<String, Integer> map)
	{
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (Integer value : map.values())
		{
			if (value == -1)
				return Integer.MAX_VALUE;
			else
			{
				max = Math.max(max, value);
				min = Math.min(min, value);
			}
		}
		return max - min;
	}
}
