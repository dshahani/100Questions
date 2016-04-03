package questions;

public class Range implements Comparable<Range>
{
	int start;
	int end;
	int range;

	public Range(int start, int end)
	{
		this.start = start;
		this.end = end;
		this.range = (end - start) + 1;
	}

	@Override
	public int compareTo(Range o)
	{
		if (this.start == o.start)
		{
			return 0;
		} else if (this.start > o.start)
		{
			return 1;
		} else
		{
			return -1;
		}

	}

}
