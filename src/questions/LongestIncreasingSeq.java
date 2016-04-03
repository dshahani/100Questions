package questions;

public class LongestIncreasingSeq
{

	public static void main(String[] args)
	{
		int[] arr = { 3, 4, -1, 0, 6, 2, 3 };

		int[] opt = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			opt[i] = 1;
		}

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[j] < arr[i] && opt[j] + 1 > opt[i])
				{
					opt[i] = opt[j] + 1;
				}
			}
		}

		int max = -999, mindex = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (max < opt[i])
			{
				max = opt[i];
				mindex = i;
			}
			System.out.print(opt[i] + "\t");
		}

		System.out.println();
		System.out.println("LIS is :" + opt[mindex]);

		for (int i = mindex; i >= 0; i--)
		{

			if (i == mindex)
			{
				System.out.print(arr[i] + "\t");
			} else
			{
				if (arr[i] < arr[i + 1])
				{
					System.out.print(arr[i] + "\t");
				}
			}

			if (opt[i] == 1)
			{
				break;
			}
		}
	}

}
