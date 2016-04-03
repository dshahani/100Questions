package questions;

/*
 * Get the least number after deleting k digits from the input number. 
 * For example, if the input number is 24635, the least number is 23 after deleting 3 digits. 
 * ( Courtesy: http://codercareer.blogspot.in/2013/11/no-48-least-number-after-deleting-digits.html)\
 */

public class LeastNumber
{

	public static void main(String[] args)
	{
		int num = 24635;
		int del = 3;
		System.out.println(deleteKNum(num, del));
		StringBuffer buf = new StringBuffer();
		System.out.println(deleDigitToGetSmallest("24635", buf, 0, 3));
	}

	public static int deleDigitToGetSmallest(String num, StringBuffer buf, int startPoint, int del)
	{
		if (del == 0)
		{
			return Integer.parseInt(buf.toString());
		}
		if (buf.length() == num.length() - del)
		{
			return 0;
		}
		if (del >= num.length() - startPoint)
		{
			return Integer.parseInt(buf.toString());
		}

		int minIndex = startPoint, minValue = Integer.MAX_VALUE;
		int len = (num.length() > startPoint + del + 1 ? startPoint + del + 1 : num.length());
		for (int i = startPoint; i < len; i++)
		{
			if (minValue > Integer.parseInt(String.valueOf(num.charAt(i))))
			{
				minValue = Integer.parseInt(String.valueOf(num.charAt(i)));
				minIndex = i;
			}
		}

		buf.append(minValue);
		return deleDigitToGetSmallest(num, buf, minIndex + 1, del - 1);
	}

	// not working
	public static int deleteKNum(int num, int del)
	{
		StringBuffer str = new StringBuffer(String.valueOf(num));
		for (int i = 0; i < del; i++)
		{
			short prev, cur;
			prev = Short.MAX_VALUE;
			boolean charDeleted = false;
			for (int j = 0; j < str.length(); j++)
			{
				cur = Short.parseShort(String.valueOf(str.charAt(j)));
				if (prev < cur)
				{
					str.deleteCharAt(j);
					charDeleted = true;
					break;
				}
				prev = cur;
			}

			if (!charDeleted)
			{
				str.deleteCharAt(str.length() - 1);
			}
		}
		return Integer.parseInt(str.toString());
	}

}
