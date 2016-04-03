package questions;

public class MultipleOf5
{
	public static void main(String[] args)
	{
		int n = 56;
		System.out.println(isMultipleof5(n));
		System.out.println(isMultipleof5V2(n));
	}

	static boolean isMultipleof5V2(int n)
	{
		String str = String.valueOf(n);
		if (str.charAt(str.length() - 1) == '5' || str.charAt(str.length() - 1) == '0')
		{
			return true;
		} else
			return false;
	}

	static boolean isMultipleof5(int n)
	{
		/*
		 * If n is a multiple of 5 then we make sure that last digit of n is 0
		 */
		if ((n & 1) == 1)
			n <<= 1;

		float x = n;
		x = ((int) (x * 0.1)) * 10;

		/* If last digit of n is 0 then n will be equal to (int)x */
		if ((int) x == n)
			return true;

		return false;
	}

}
