package questions;

public class DivideNumber
{

	public static void main(String[] args)
	{
		int x = 21, y = 7;
		int ans = division(x, y);
		System.out.println("Division of " + x + " and " + y + " is " + ans);

	}

	public static int add(int x, int y)
	{
		int carry;
		while (y != 0)
		{
			carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}
		return x;
	}

	public static int subtract(int x, int y)
	{
		int borrow;
		while (y != 0)
		{
			borrow = (~x) & y;
			x = x ^ y;
			y = borrow << 1;
		}
		return x;
	}

	public static int division(int dividend, int divisor)
	{
		boolean negative = false;
		if ((dividend & (1 << 31)) == (1 << 31))
		{ // Check for signed bit
			negative = !negative;
			dividend = add(~dividend, 1); // Negation
		}
		if ((divisor & (1 << 31)) == (1 << 31))
		{
			negative = !negative;
			divisor = add(~divisor, 1); // Negation
		}
		int quotient = 0;
		long r;
		for (int i = 30; i >= 0; i = subtract(i, 1))
		{
			r = (divisor << i);
			// Left shift divisor until it's smaller than dividend
			if (r < Integer.MAX_VALUE && r >= 0)
			{ // Avoid cases where comparison between long and int doesn't make
				// sense
				if (r <= dividend)
				{
					quotient |= (1 << i);
					dividend = subtract(dividend, (int) r);
				}
			}
		}
		if (negative)
		{
			quotient = add(~quotient, 1);
		}
		return quotient;
	}

}
