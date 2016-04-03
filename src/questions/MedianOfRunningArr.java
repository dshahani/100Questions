package questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningArr
{

	PriorityQueue<Integer> r = new PriorityQueue<Integer>();
	PriorityQueue<Integer> l = new PriorityQueue<Integer>(Collections.reverseOrder());

	// Function implementing algorithm to find median so far.
	int getMedian(int e, int m, PriorityQueue<Integer> l, PriorityQueue<Integer> r)
	{
		// Are heaps balanced? If yes, sig will be 0
		int sig = (l.size() > r.size() ? 1 : (l.size() == r.size() ? 0 : -1));
		switch (sig)
		{
			case 1: // There are more elements in left (max) heap

				if (e < m) // current element fits in left (max) heap
				{
					// Remore top element from left heap and
					// insert into right heap
					r.add(l.poll());

					// current element fits in left (max) heap
					l.add(e);
				} else
				{
					// current element fits in right (min) heap
					r.add(e);
				}

				// Both heaps are balanced
				m = (l.peek() + r.peek()) / 2;

				break;

			case 0: // The left and right heaps contain same number of elements

				if (e < m) // current element fits in left (max) heap
				{
					l.add(e);
					m = l.peek();
				} else
				{
					// current element fits in right (min) heap
					r.add(e);
					m = r.peek();
				}

				break;

			case -1: // There are more elements in right (min) heap

				if (e < m) // current element fits in left (max) heap
				{
					l.add(e);
				} else
				{
					// Remove top element from right heap and
					// insert into left heap
					l.add(r.poll());

					// current element fits in right (min) heap
					r.add(e);
				}

				// Both heaps are balanced
				m = (l.peek() + r.peek()) / 2;

				break;
		}

		// No need to return, m already updated
		return m;
	}
}
