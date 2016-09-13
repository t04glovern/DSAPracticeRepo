public class FactorialMain {

	public static void main(String[] args)
	{
		Factorial fact = new Factorial(10);
	}

	public static class Factorial {

		int resultEven = 0;
		int factorialNum = 0;

		public Factorial(int inNum)
		{
			this.factorialNum = inNum;
			runFactorial();
		}

		public void runFactorial()
		{
			System.out.println(fact(factorialNum));
			System.out.println("Even sum: " + resultEven);
		}

		private int fact(int factorial)
		{
			int result;
			if (factorial == 0 || factorial == 1)
			{
				return 1;
			}
			int resultTest = fact(factorial-1) * factorial;
			if((resultTest % 2) == 0)
			{
				resultEven = resultEven + resultTest;
			}
			result = resultTest;
			return result;
		}
	}
}

