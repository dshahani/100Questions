package questions;

import java.util.ArrayList;
import java.util.List;

public class IsPowerOfTwo
{

	public static void main(String[] args)
	{
		int number = 24;
		IsPowerOfTwo obj = new IsPowerOfTwo();
		System.out.println(obj.isPowerOfTwoV1(number));
		System.out.println(obj.isPowerOfTwoV2(number));
		System.out.println(obj.isPowerOfTwoV3(number));
		System.out.println(obj.isPowerOfTwoV4(number));
		System.out.println(obj.isPowerOfTwoV5(number));

	}

	public boolean isPowerOfTwoV1(int number)
	{
		while ((number % 2 == 0) && number > 1)
		{
			number /= 2;
		}
		return (number == 1);
	}

	public boolean isPowerOfTwoV2(int number)
	{
		List<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i <= 31; i++)
		{
			lst.add((int) Math.pow(2, i));
		}
		int len = lst.size(), start = 0, end = len, index;

		while (start <= end)
		{
			index = (start + end) / 2;
			if (lst.get(index) == number)
			{
				return true;
			} else if (lst.get(index) > number)
			{
				end = index - 1;
			} else
			{
				start = index + 1;
			}
		}
		return false;
	}

	public boolean isPowerOfTwoV3(int x)
	{
		if ((x > 0) && ((x & (x - 1)) == 0))
		{
			return true;
		} else
			return false;
	}

	public boolean isPowerOfTwoV4(int x)
	{
		int count = 0;
		while (x > 1)
		{
			if ((x & 1) > 0)
			{
				count++;
			}
			if (count >= 1)
				break;

			x >>= 1;
		}

		if (x == 1)
			return true;
		else
			return false;
	}

	public boolean isPowerOfTwoV5(int x)
	{
		while (((x & 1) == 0) && x > 1)
		{
			x = x >> 1;
		}

		if (x == 1)
			return true;
		else
			return false;
	}
}
