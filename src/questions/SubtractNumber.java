package questions;

public class SubtractNumber
{

	public static void main(String[] args)
	{
		int x = 15, y = 20;
		int ans = subtract(x, y);
		System.out.println("Subtraction of " + x + " and " + y + " is " + ans);

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

}
