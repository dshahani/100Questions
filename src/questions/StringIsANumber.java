package questions;

public class StringIsANumber
{
	public static void main(String[] arg)
	{
		System.out.println(isNumber("--123.3"));
	}

	public static boolean isNumber(String s)
	{
		boolean signOccured = false;
		boolean dotOccured = false;
		boolean started = false;

		s = s.trim();

		for (char c : s.toCharArray())
		{
			if (c == '+' || c == '-')
			{
				if (started || signOccured || dotOccured)
				{
					return false;
				} else
				{
					signOccured = true;
				}
			} else if (c >= '0' && c <= '9')
			{
				started = true;
			} else if (c == '.')
			{
				if (dotOccured)
				{
					return false;
				} else
				{
					dotOccured = true;
				}
			} else
			{
				return false;
			}

		}
		return true;
	}

}
