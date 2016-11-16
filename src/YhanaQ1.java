public class YhanaQ1
{

	public static void main(String[] args)
	{
		int n = 81;
		YhanaQ1 test = new YhanaQ1();
		test.testNumber(n);
	}

	public void testNumber(int inValue)
	{
		int count = 0;

		while(inValue != 1)
		{
			count++;
			if(isEven(inValue))
			{
				System.out.print("Count: " + count + ", n: " + inValue + ", EVEN");
				System.out.println();
				inValue = inValue / 2;
			}
			else
			{
				System.out.print("Count: " + count + ", n: " + inValue + ", ODD");
				System.out.println();
				inValue = inValue * 3 + 1;
			}
		}
	}

	public boolean isEven(int inValue)
	{
		if(inValue % 2 == 0)
			return true;
		return false;
	}
}
