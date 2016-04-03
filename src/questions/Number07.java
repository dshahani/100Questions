package questions;

public class Number07
{
	static long NUM = 19;

	public static void main(String[] args)
	{
		// NUM is the given number
		// find007() finds the smallest number with 0 & 7 that is divided by
		// NUM
		System.out.print(find007(NUM));
	}

	static long find007(long n)
	{

		if (is007(n))
			return n;

		if (n + NUM < n)
			return 0;

		return find007(n + NUM);
	}

	static boolean is007(long n)
	{
		while (n != 0 && (n % 10 == 0 || n % 10 == 1))
			n = n / 10;

		return n == 0;
	}
}
