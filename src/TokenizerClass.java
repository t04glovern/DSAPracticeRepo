import java.util.StringTokenizer;

public class TokenizerClass {

	public static void main(String[] args)
	{
		String testString = "This is a string";
		String testStringComma = "This,is,a,string";

		StringTokenizer st = new StringTokenizer(testString);
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}

		String[] testSplit = testStringComma.split(",");
		for(int x = 0; x < testSplit.length; x++)
		{
			System.out.println(testSplit[x]);
		}
	}
}
