package questions;

public class FindNumCmnChar
{

	public static void main(String[] args)
	{
		String[] strArr = { "aghkafgklt", "dfghako", "qwemnaarkf" };
		System.out.println("count is : " + countCmnchar(strArr));
	}

	public static int countCmnchar(String[] str)
	{
		int[] arr = new int[str.length];

		for (int i = 0; i < str.length; i++)
		{
			char[] charArr = str[i].toCharArray();
			int bit = 0;
			for (char c : charArr)
			{
				bit = bit | (1 << (c - 'a'));
			}
			arr[i] = bit;
		}

		int res = -1;
		for (int i = 0; i < arr.length; i++)
		{
			res = res & arr[i];
		}
		int count = 0, rep = 0;
		while (res > 0)
		{

			if ((res & 1) > 0)
			{
				rep++;
				System.out.println((char) ('a' + count));
			}
			count++;
			res = res >> 1;
		}
		return rep;
	}

}
