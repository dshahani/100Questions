package questions;

public class StringRepresentationOfBinaryTree
{
	public static void main(String[] args)
	{
		String s = "((00)0(0(00))))";
		System.out.println(find_dept(s, 0, s.length() - 1));
	}

	private static int find_dept(String s, int startIndex, int endIndex)
	{
		int split = getSplit(s, startIndex + 1, endIndex - 1);
		if (s.charAt(startIndex) == '(' && s.charAt(endIndex) == ')' && split > -1
				&& (s.charAt(startIndex + 1) == '(' || s.charAt(startIndex + 1) == '0')
				&& (s.charAt(endIndex - 1) == ')' || s.charAt(endIndex - 1) == '0') && startIndex < endIndex - 2)
			return 1 + Math.max(find_dept(s, startIndex + 1, split), find_dept(s, split + 1, endIndex - 1));
		else
			return -1;
	}

	/**
	 * Find a potential for the recursive call
	 */
	private static int getSplit(String s, int startIndex, int endIndex)
	{
		int c = 0;
		int split = -1;
		for (int i = startIndex; i <= endIndex; i++)
		{
			if (s.charAt(i) == '(')
				c++;
			else if (s.charAt(i) == ')')
				c--;
			if (c == 0)
			{
				split = i;
				break;
			}
		}
		return split;
	}
}
