import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FileReadWrite {

	public static void main(String[] args)
	{
		//DSAStack stack = new DSAStack(8000);
		DSAQueue queue = new DSAQueue(8000);
		FileReadWrite fileReadWrite = new FileReadWrite();

		FileInputStream fileInput;
		InputStreamReader inputStream;
		BufferedReader buffer;

		String filename = "filedump/SacramentocrimeJanuary2006.csv";
		try
		{
			fileInput = new FileInputStream(filename);
			inputStream = new InputStreamReader(fileInput);
			buffer = new BufferedReader(inputStream);

			String line = buffer.readLine();
			while(line != null)
			{
				queue.enqueue(ProcessLine(line));
				//stack.push(ProcessLine(line));
				line = buffer.readLine();
			}
		}
		catch (IOException e)
		{
			System.out.println("IOFailed");
		}

		printCrimeInfoQueue(queue);
		//printCrimeInfoStack(stack);
	}

	public static CrimeInfo ProcessLine(String inLine)
	{
		CrimeInfo crime = new CrimeInfo();
		StringTokenizer st = new StringTokenizer(inLine,",");
		while(st.hasMoreTokens())
		{
			String date = st.nextToken();
			String address = st.nextToken();
			String district = st.nextToken();
			String beat = st.nextToken();
			String grid = st.nextToken();
			String description = st.nextToken();
			String id = st.nextToken();
			String latitude = st.nextToken();
			String longitude = st.nextToken();

			if(!date.equals("cddatetime"))
			{
				crime.setCrimeDate(date);
				crime.setCrimeAddress(address);
				crime.setDistrict(district);
				crime.setBeat(beat);
				crime.setGrid(grid);
				crime.setCrimeDescription(description);
				crime.setCrimeID(id);
				crime.setCrimeLatitude(latitude);
				crime.setCrimeLongitude(longitude);
			}
		}
		return crime;
	}

	public static void printCrimeInfoStack(DSAStack inStack)
	{
		while(!inStack.isEmpty())
		{
			CrimeInfo crime = (CrimeInfo)inStack.pop();
			System.out.println("crime ID: " + crime.getCrimeID() + " took place at " + crime.getCrimeAddress());
		}
	}

	public static void printCrimeInfoQueue(DSAQueue inQueue)
	{
		while(!inQueue.isEmpty())
		{
			CrimeInfo crime = (CrimeInfo)inQueue.dequeue();
			System.out.println("crime ID: " + crime.getCrimeID() + " took place at " + crime.getCrimeAddress());
		}
	}
}
