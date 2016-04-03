package questions;

import java.util.ArrayList;
import java.util.List;

public class DivideArrInEqual
{

	public static void main(String[] args)
	{
		int[] arr = { 10, 15, 1, 3, 11, 7, 5, 4, 8, 8 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		int mid = divide(arr, 0, 0, 0);
		mid = (sum + mid) / 2;
		int dif = Integer.MAX_VALUE;
		int[] opt = new int[arr.length];
		opt[0] = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (dif > Math.abs((mid - (arr[i] + opt[i - 1]))))
			{
				opt[i] = opt[i - 1] + arr[i];
				dif = Math.abs((mid - (arr[i] + opt[i - 1])));
			} else
			{
				opt[i] = opt[i - 1];
			}
		}

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(opt[i] + "\t");
		}

		List<Integer> first = new ArrayList<Integer>();
		List<Integer> second = new ArrayList<Integer>();
		first.add(arr[0]);
		for (int i = 1; i < opt.length; i++)
		{
			if (opt[i - 1] < opt[i])
			{
				first.add(arr[i]);
			} else
			{
				second.add(arr[i]);
			}
		}
		System.out.println("");
		sum = 0;
		for (Integer t : first)
		{
			sum += t;
			System.out.print(t + "\t");
		}
		System.out.println("\n" + sum);
		sum = 0;
		for (Integer t : second)
		{
			sum += t;
			System.out.print(t + "\t");
		}
		System.out.println("\n" + sum);
	}

	public static int divide(int[] a, int i, int x, int y)
	{
		if (i >= a.length)
		{
			return Math.abs(x - y);
		} else
		{
			int x1 = divide(a, i + 1, x + a[i], y);
			int x2 = divide(a, i + 1, x, y + a[i]);
			return Math.min(x1, x2);
		}
	}
}
