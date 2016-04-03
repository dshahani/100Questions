package questions;

public class AddingNumber
{

	public static void main(String[] args)
	{

		System.out.println("Hello. My name is Emma Altmeyer.");
		System.out.println("I am a senior at USC. My major is Screenwriting.");
		System.out.println("I chose java because I haven't taken a programming class since high school.");
		System.out.println("I am very comfortable using computers.");
		System.out.println("I have studied BASIC and some HTML before, but do not know much about programming.");
		System.out.println("My three goals in this class are to be on time, learn something new, and master Java.");
		System.out.println("An interesting fact about me is I have a pet cat.");
		System.out.println("My dream is to be a screenwriter.");
		System.out.println("Nice to meet you!");

		// System.out.println((int) '5' - (int) '0');
		int x = 15, y = 20;
		int ans = add(x, y);
		// System.out.println("Addition of " + x + " and " + y + " is " + ans);

	}

	public static void print(int f, int in)
	{
		System.out.println(f + "'" + in + "\"");
	}

	public static int add(int x, int y)
	{
		int carry;
		while (y != 0)
		{
			carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}
		return x;
	}

}
