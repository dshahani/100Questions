package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RangeOfSet
{
	static class Interval
	{
		int start, end;

		Interval(int x, int y)
		{
			this.start = x;
			this.end = y;
		}
	}

	public static void main(String[] arg)
	{
		Interval i = new Interval(1, 3);
		Interval j = new Interval(2, 5);
		Interval k = new Interval(8, 9);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i);
		intervals.add(j);
		intervals.add(k);
		System.out.println(findRange(intervals));
	}

	public static int findRange(ArrayList<Interval> intervals)
	{
		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval o1, Interval o2)
			{
				if (o1.start > o2.start)
				{
					return 1;
				} else if (o1.start > o2.start)
				{
					return -1;
				} else if (o1.end > o2.end)
				{
					return 1;
				} else if (o1.end > o2.end)
				{
					return -1;
				} else
				{
					return 0;
				}
			}
		});

		int range = 0;
		int s = 0;
		int i = 0;
		while (i < intervals.size())
		{
			int j = i + 1;
			int e = intervals.get(i).end;
			while (j < intervals.size() && e >= intervals.get(j).start)
			{
				e = Math.max(e, intervals.get(j).end);
				j++;

			}
			range += e - intervals.get(s).start;
			i = j;
			s = j;
		}
		return range;
	}
}
