package questions;

public class PowerFunction
{

	public static void main(String[] args)
	{
		System.out.println(calculatePower(2, 10));
	}

	public static double calculatePower(double x, int y)
	{
		double temp;
		if (y == 0)
		{
			return 1;
		}
		temp = calculatePower(x, y / 2);
		if (y % 2 == 0)
		{
			return temp * temp;
		} else
		{
			if (y > 0)
			{
				return x * temp * temp;
			} else
			{
				return (temp * temp) / x;
			}
		}
	}

}
