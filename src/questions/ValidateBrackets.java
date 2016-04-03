package questions;

import java.util.Stack;

/*
 * Find if the given expression contains redundant parantheses. ex :if expr = a+(b*c) 
 * print false, if expr = a+((b*c)), print true.
 */

public class ValidateBrackets
{
	public static void main(String[] args)
	{
		String str = "(a+(b*c))";
		System.out.println(validateBrackets(str));
	}

	public static boolean validateBrackets(String s)
	{
		Stack<Character> stck = new Stack<Character>();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == ')')
			{
				if (stck.peek() == '(')
				{
					return false;
				} else
				{
					while (stck.peek() != '(')
					{
						stck.pop();
					}
					stck.pop();
				}
			} else
			{
				stck.push(s.charAt(i));
			}
		}
		return true;
	}

	public static String[] isParenthesisMatch(String[] values)
	{
		String[] res = new String[values.length];

		for (int j = 0; j < values.length; j++)
		{
			Stack<Character> stack = new Stack<Character>();
			String str = values[j];
			String out = "";
			char c;
			for (int i = 0; i < str.length(); i++)
			{
				c = str.charAt(i);
				if (c == '(')
					stack.push(c);
				else if (c == '{')
					stack.push(c);
				else if (c == '[')
					stack.push(c);
				else if (c == ')')
				{
					if (stack.empty())
					{
						out = "NO";
						break;
					} else if (stack.peek() == '(')
						stack.pop();
					else
					{
						out = "NO";
						break;
					}
				} else if (c == '}')
				{
					if (stack.empty())
					{
						out = "NO";
						break;
					} else if (stack.peek() == '{')
						stack.pop();
					else
					{
						out = "NO";
						break;
					}
				} else if (c == ']')
				{
					if (stack.empty())
					{
						out = "NO";
						break;
					} else if (stack.peek() == '[')
						stack.pop();
					else
					{
						out = "NO";
						break;
					}
				}

			}
			if (stack.isEmpty())
			{
				out = "YES";
			}
			res[j] = out;
		}
		return res;
	}
}
