package questions;

public class MinimumInTwoArrays
{

	public static int findMin(int[] a, int[] b)
	{
		int i = 0, j = 0, ans = Integer.MAX_VALUE;
		while (i < a.length && j < b.length)
		{
			if (a[i] <= b[j])
			{
				ans = Math.min(ans, b[j] - a[i]);
				i++;
			} else
			{
				ans = Math.min(ans, a[i] - b[j]);
				j++;
			}
		}
		return ans;
	}
}
