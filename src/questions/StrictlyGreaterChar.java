package questions;

public class StrictlyGreaterChar
{
	/**
	 * Return the smallest character that is strictly larger than the search
	 * character, otherwise return the first character in the string.
	 * 
	 * @param sortedStr
	 *            : sorted list of letters, sorted in ascending order.
	 * @param c
	 *            : character for which we are searching. Given the following
	 *            inputs we expect the corresponding output: ['c', 'f', 'j',
	 *            'p', 'v'], 'a' => 'c' ['c', 'f', 'j', 'p', 'v'], 'c' => 'f'
	 *            ['c', 'f', 'j', 'p', 'v'], 'k' => 'p' ['c', 'f', 'j', 'p',
	 *            'v'], 'z' => 'c' // The wrap around case ['c', 'f', 'k'], 'f'
	 *            => 'k' ['c', 'f', 'k'], 'c' => 'f' ['c', 'f', 'k'], 'd' => 'f'
	 */

	public static char findNextChar(char[] list, char c)
	{
		assert list.length > 0;
		int left = 0, right = list.length - 1;
		char result = list[0];
		while (left < right)
		{
			int mid = left + (right - left) / 2;
			if (list[mid] == c)
			{
				if (mid < list.length - 1)
					return list[mid + 1];
				else
					return result;
			} else if (list[mid] < c)
			{
				left = mid + 1;
			} else
			{// list[mid] > c
				result = list[mid];
				right = mid - 1;
			}
		}
		return result;
	}

	public class Solution
	{

		public char smallestChar(char[] chars, char searchChar)
		{

			for (int i = 0; i < chars.length; i++)
			{
				if (chars[i] > searchChar)
				{
					return chars[i];
				}
			}

			return chars[0];
		}

		// ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'

		public char smallestCharBin(char[] chars, char searchChar, int low, int high)
		{
			int mid = (low + high) / 2;

			if (chars[mid] > searchChar && (mid < 1 || chars[mid - 1] <= searchChar))
			{
				return chars[mid];
			} else if (chars[mid] <= searchChar)
			{
				return smallestCharBin(chars, searchChar, mid + 1, high);
			} else
			{
				return smallestCharBin(chars, searchChar, low, mid - 1);
			}
		}
	}
}
