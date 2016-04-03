package questions;

public class IntegerLib
{

	public static void main(String[] args)
	{
		System.out.println(toString(123));
		System.out.println(parseInt("-123"));
	}

	public static String toString(int n)
	{
		StringBuffer buf = new StringBuffer("");
		while (n > 0)
		{
			int r = n % 10;
			char c = (char) ('0' + r);
			n = n / 10;
			buf.append(c);
		}
		return buf.reverse().toString();
	}

	public static int parseInt(String s)
	{
		int pow = 1, size = s.length(), res = 0;
		boolean minus = false;

		for (int i = size - 1; i >= 0; i--)
		{
			if (s.charAt(i) == '-')
			{
				minus = true;
				continue;
			}
			int r = s.charAt(i) - '0';
			res += r * pow;
			pow *= 10;
		}

		if (minus)
		{
			res = ~res;
			res += 1;
		}
		return res;

	}

}
