package questions;

public class MultiplyNumber
{

	public static void main(String[] args)
	{
		int x = 15, y = 20;
		int ans = mult(x, y);
		System.out.println("Multiplication of " + x + " and " + y + " is " + ans);

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

	public static int mult(int a, int b)
	{
		int i = 0;
		int c = 0;
		while (i < b)
		{
			c = add(c, a);
			i = add(i, 1);
		}
		return c;
	}

}
