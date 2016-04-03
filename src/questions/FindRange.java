package questions;

/*
 * For example, find_range({0 2 3 3 3 10 10}, 3) should return (2,4). find_range({0 2…
 */

public class FindRange
{

	public static void main(String[] args)
	{
		int[] a = { 0, 2, 3, 3, 3, 10, 10 };
		System.out.println(findRange(a, 3, 0, a.length - 1));

	}

	public static String findRange(int[] a, int number, int start, int end)
	{
		if (start > end)
		{
			return "";
		}
		int mid = (end + start) / 2;
		String rangeStart = "", rangeEnd = "";

		if (a[mid] > number)
		{
			rangeEnd = findRange(a, number, start, mid - 1);
		} else if (a[mid] < number)
		{
			rangeStart = findRange(a, number, mid + 1, end);
		} else
		{
			if (mid + 1 < a.length && a[mid + 1] == number)
			{
				rangeEnd = findRange(a, number, mid + 1, end);
			} else
			{
				rangeEnd = String.valueOf(mid);
			}

			if (mid - 1 >= 0 && a[mid - 1] == number)
			{
				rangeStart = findRange(a, number, start, mid - 1);
			} else
			{
				rangeStart = String.valueOf(mid);
			}
		}

		if (!rangeEnd.isEmpty() && !rangeStart.isEmpty())
		{
			return ("(" + rangeStart + "," + rangeEnd + ")");
		} else if (!rangeStart.isEmpty())
		{
			return rangeStart;
		} else if (!rangeEnd.isEmpty())
		{
			return rangeEnd;
		} else
		{
			return "(-1,-1)";
		}

	}

}
