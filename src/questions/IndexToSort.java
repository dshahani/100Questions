package questions;

public class IndexToSort
{
	public static void main(String[] arg)
	{
		int[] arr = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		int a = 0, b = 0;

		for (int i = 0; i < arr.length - 1; i++)
		{
			if (arr[i] > arr[i + 1])
			{
				if (a == 0)
				{
					a = i;
				} else
				{
					b = i;
				}
			}
		}

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "\t");
			if (i == a || i == b)
			{
				System.out.println("");
			}
		}
		int min = 999, max = -1;
		for (int i = a + 1; i <= b; i++)
		{
			if (min > arr[i])
			{
				min = arr[i];
			}
			if (max < arr[i])
			{
				max = arr[i];
			}
		}

		for (int i = a; i >= 0; i--)
		{
			if (arr[i] > min)
			{
				a--;
			}
		}

		for (int i = b; i < arr.length; i++)
		{
			if (arr[i] < max)
			{
				b++;
			}
		}

		System.out.println("");
		for (int i = 0; i < arr.length; i++)
		{
			if (i == a)
			{
				System.out.println("");
			}
			System.out.print(arr[i] + "\t");
			if (i == b)
			{
				System.out.println("");
			}
		}
	}
}
