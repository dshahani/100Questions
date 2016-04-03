package questions;

import java.util.ArrayList;

public class MergeIntervals
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public ArrayList<Range> insert(ArrayList<Range> Ranges, Range newRange)
	{

		ArrayList<Range> result = new ArrayList<Range>();

		for (Range Range : Ranges)
		{
			if (Range.end < newRange.start)
			{
				result.add(Range);
			} else if (Range.start > newRange.end)
			{
				result.add(newRange);
				newRange = Range;
			} else if (Range.end >= newRange.start || Range.start <= newRange.end)
			{
				newRange = new Range(Math.min(Range.start, newRange.start), Math.max(newRange.end, Range.end));
			}
		}

		result.add(newRange);

		return result;
	}

}
