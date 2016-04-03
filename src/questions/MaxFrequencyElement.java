package questions;

public class MaxFrequencyElement
{
	/* Function to find the candidate for Majority */
	int findCandidate(int a[], int size)
	{
		int maj_index = 0, count = 1;
		int i;
		for (i = 1; i < size; i++)
		{
			if (a[maj_index] == a[i])
				count++;
			else
				count--;
			if (count == 0)
			{
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}

	/* Function to check if the candidate occurs more than n/2 times */
	boolean isMajority(int a[], int size, int cand)
	{
		int i, count = 0;
		for (i = 0; i < size; i++)
			if (a[i] == cand)
				count++;
		if (count > size / 2)
			return true;
		else
			return false;
	}
}
