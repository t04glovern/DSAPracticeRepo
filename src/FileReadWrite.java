import java.io.*;
import java.util.StringTokenizer;

public class FileReadWrite {

	public static void main(String[] args)
	{
		DSAStack stack = new DSAStack(8000);
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
				stack.push(ProcessLine(line));
				line = buffer.readLine();
			}

			inputStream.close();
		}
		catch (IOException e)
		{
			System.out.println("IOFailed");
		}

		//printCrimeInfoQueue(queue);
		//printCrimeInfoStack(stack);

		//saveRecordsToFileFromDataStructure(stack);
		saveRecordsToFileFromDataStructure(queue);

		CrimeInfo loadedCrime = loadCrimeFromFile("2302");
		System.out.println(loadedCrime.getCrimeID() + " at address " + loadedCrime.getCrimeAddress());
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

	public static void saveRecordToFile(CrimeInfo inCrime)
	{
		FileOutputStream fileOut;
		ObjectOutputStream objectOutput;

		try
		{
			fileOut = new FileOutputStream("filedump/crimes/"+inCrime.getCrimeID());
			objectOutput = new ObjectOutputStream(fileOut);

			objectOutput.writeObject(inCrime);
			fileOut.close();
		}
		catch (IOException e)
		{
			System.out.println("Disk IO error");
		}
	}

	public static CrimeInfo loadCrimeFromFile(String crimeID)
	{
		CrimeInfo crime = null;

		FileInputStream fileIn;
		ObjectInputStream objectIn;

		try
		{
			fileIn = new FileInputStream("filedump/crimes/"+crimeID);
			objectIn = new ObjectInputStream(fileIn);

			crime = (CrimeInfo)objectIn.readObject();
			fileIn.close();
		}
		catch (IOException e)
		{
			System.out.println("Disk IO error or File not found");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Object class not found");
		}
		return crime;
	}

	public static void saveRecordsToFileFromDataStructure(Object inDataStructure)
	{
		if(inDataStructure instanceof DSAQueue)
		{
			while(!((DSAQueue) inDataStructure).isEmpty())
			{
				saveRecordToFile((CrimeInfo)(((DSAQueue) inDataStructure).dequeue()));
			}
		}
		if(inDataStructure instanceof DSAStack)
		{
			while(!((DSAStack) inDataStructure).isEmpty())
			{
				saveRecordToFile((CrimeInfo)((DSAStack) inDataStructure).pop());
			}
		}
	}
}
