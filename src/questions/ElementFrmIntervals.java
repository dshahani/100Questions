package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * Given a set of intervals like 5-10, 5-10, 8-12, 9-15. 
 * Find the ith smallest number in these intervals.
 * for eg:-Suppose we have intervals like 5-10, 8-12.
 * Then total numbers in these two intervals would be: {5,6,7,8,8,9,9,10,10,11,12} 
 * So, 1st smallest number: 5 4th smallest number: 8 5th smallest number: 8
 */
public class ElementFrmIntervals
{

	public static void main(String[] args)
	{
		ArrayList<Range> range = new ArrayList<Range>();
		Range o1 = new Range(5, 10);
		range.add(o1);
		/*
		 * o1 = new Range(5, 10); range.add(o1);
		 */
		o1 = new Range(8, 12);
		range.add(o1);
		/*
		 * o1 = new Range(9, 15); range.add(o1);
		 */

		Collections.sort(range);
		ArrayList<Range> filterRslt = filterLst(range, 6);
		ArrayList<Integer[]> comLst = combineRange(filterRslt);
		System.out.println(findIthElement(comLst, 1));

	}

	public static int findIthElement(ArrayList<Integer[]> range, int element)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < range.size(); i++)
		{
			minHeap.add(range.get(i)[0]);
		}

		int res = 0;
		int index = 1;
		ArrayList<Integer> al;
		for (int k = 0; k < element; k++)
		{
			res = minHeap.poll();
			al = new ArrayList<Integer>();
			for (int i = 0; i < range.size(); i++)
			{
				if (range.get(i).length > index)
				{
					al.add(range.get(i)[index]);
				}

			}
			Collections.sort(al);
			index++;
			minHeap.add(al.get(0));
		}
		return res;
	}

	public static ArrayList<Integer[]> combineRange(ArrayList<Range> range)
	{
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		Iterator<Range> it = range.iterator();
		Range obj;
		while (it.hasNext())
		{
			obj = it.next();
			Integer[] arr = new Integer[obj.range];
			int index = 0;
			for (int i = obj.start; i <= obj.end; i++)
			{
				arr[index++] = i;
			}
			result.add(arr);
		}
		return result;
	}

	public static ArrayList<Range> filterLst(ArrayList<Range> range, int depth)
	{
		ArrayList<Range> result = new ArrayList<Range>();
		result.add(range.get(0));
		int start = range.get(0).start;
		for (int i = 1; i < range.size(); i++)
		{
			if ((start + depth) > range.get(i).start)
			{
				result.add(range.get(i));
			} else
			{
				break;
			}
		}
		return result;
	}

}
