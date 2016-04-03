package questions;

public class Fibonacci
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static long fib(int n)
	{
		if (n <= 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static long fibItr(int n)
	{
		int count = 1;
		int c = 1, b = 1, a = 0;
		while (count <= n)
		{
			c = b + a;
			System.out.print(c);
			a = b;
			b = c;
			count++;
		}
		return c;
	}
}
