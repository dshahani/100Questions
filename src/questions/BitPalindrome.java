package questions;

import java.util.Stack;

public class BitPalindrome
{
	public static void main(String[] args)
	{
		int n = 9;
		String bit = intToBinary(n);
		System.out.println(bit);
		int ans = binaryToInt(bit);
		System.out.println(ans);
		System.out.println(checkPalin(bit));
	}

	public static boolean checkPalin(String s)
	{
		StringBuffer buf = new StringBuffer(s);
		if (s.equals(buf.reverse().toString()))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public static int binaryToInt(String s)
	{
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if (s.charAt(i) == '1')
			{
				res += Math.pow(2, s.length() - 1 - i);
			}
		}
		return res;
	}

	public static String intToBinary(int n)
	{
		Stack<Short> stck = new Stack<Short>();

		while (n > 0)
		{
			if (n % 2 > 0)
			{
				stck.push((short) 1);
			} else
			{
				stck.push((short) 0);
			}
			n = n / 2;
		}

		StringBuffer buf = new StringBuffer();
		while (!stck.isEmpty())
		{
			buf.append(stck.pop());
		}
		return buf.toString();
	}

	static long CountBits(long input)
	{
		long count = 0;
		while (input > 0)
		{
			if (input % 2 > 0)
			{
				count++;
			}
			input = input / 2;
		}
		return count;
	}

}
