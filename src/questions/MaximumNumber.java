package questions;

public class MaximumNumber
{

	public static void main(String[] args)
	{
		int a = 50, b = 10;
		int c = a - b;
		int k = sign(c);
		int q = flip(k);
		System.out.println(a * k + b * q);

	}

	public static int flip(int a)
	{
		return 1 ^ a;
	}

	public static int sign(int a)
	{
		return ((a >> 31) ^ 1);
	}

}
