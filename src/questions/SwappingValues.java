package questions;

public class SwappingValues
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static void swapNumbersV1(int a, int b)
	{
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.print(a + "\t" + b);
	}

	public static void swapNumbersV2(int a, int b)
	{
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.print(a + "\t" + b);
	}

	public static void swapNumbersV3(int a, int b)
	{
		a = a ^ b ^ (b = a);
		System.out.print(a + "\t" + b);
	}

	public static void swapNumbersV1(int a, int b, int c)
	{
		a = a + b + c;
		b = a - b - c;
		c = a - b - c;
		a = a - b - c;
		System.out.print(a + "\t" + b + "\t" + c);
	}

	public static void swapNumbersV2(int a, int b, int c)
	{
		a = a ^ b ^ c;
		b = a ^ b ^ c;
		c = a ^ b ^ c;
		a = a ^ b ^ c;
		System.out.print(a + "\t" + b + "\t" + c);
	}

	public static void swapNumbersV3(int a, int b, int c)
	{
		a = a ^ b ^ c ^ (b = a) ^ (c = b);
		System.out.print(a + "\t" + b + "\t" + c);
	}
}
