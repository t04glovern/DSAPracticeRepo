import java.math.*;

public class ExponentialFunc
{
	public static void main(String args[])
	{
		int inValue = 1; // this is the in value
		int step = 2; // start at two because 1 + x are already covered before the loop starts
		boolean finish = false; // used to escape out of the while loop
		double expVal = 1 + inValue;

		while(!finish)
		{
			// calculate the value
			double temp = (Math.pow(inValue, step)) / (fact(step));
			// add to the previous value
			expVal = expVal + temp;
			System.out.println(expVal); // prints out the value

			if(temp < 0.1) // checks if the value calculated is less than 0.1
			{
				finish = true;
			}
			// increment step
			step++;
		}
	}

	// My factorial function, maybe confirm that it makes sense and I didn't stuff up
	private static int fact(int factorial)
	{
		int result;
		if (factorial == 0 || factorial == 1)
		{
			return 1;
		}
		result = fact(factorial-1) * factorial;
		return result;
	}
}