package questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	boolean areIsomorphic(String str1, String str2)
	{

		int m = str1.length(), n = str2.length();

		// Length of both strings must be same for one to one
		// corresponance
		if (m != n)
			return false;

		// To mark visited characters in str2
		Set<Character> marked = new HashSet<Character>();
		// bool marked[MAX_CHARS] = {false};

		// To store mapping of every character from str1 to
		// that of str2. Initialize all entries of map as -1.
		Map<Character, Character> map = new HashMap<Character, Character>();
		// int map[MAX_CHARS];

		// Process all characters one by on
		for (int i = 0; i < n; i++)
		{
			// If current character of str1 is seen first
			// time in it.
			if (!map.containsKey(str1.charAt(i)))
			{
				// If current character of str2 is already
				// seen, one to one mapping not possible
				if (marked.contains(str2.charAt(i)))
					return false;

				// Mark current character of str2 as visited
				marked.add(str2.charAt(i));
				// marked[str2[i]] = true;

				// Store mapping of current characters
				map.put(str1.charAt(i), str2.charAt(i));
				// map[str1[i]] = str2[i];
			}

			// If this is not first appearance of current
			// character in str1, then check if previous
			// appearance mapped to same character of str2
			else if (map.get(str1.charAt(i)) != str2.charAt(i))
				return false;
		}

		return true;
	}

}
