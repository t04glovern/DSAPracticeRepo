import java.io.Serializable;
import java.util.Date;

public class CrimeInfo implements Serializable {

	private String crimeDate;
	private String crimeAddress;
	private String district;
	private String beat;
	private String grid;
	private String crimeDescription;
	private String crimeID;
	private String crimeLatitude;
	private String crimeLongitude;

	public CrimeInfo()
	{
		this.crimeDate = "N/A";
		this.crimeAddress = "N/A";
		this.district = "N/A";
		this.beat = "N/A";
		this.grid = "N/A";
		this.crimeDescription = "N/A";
		this.crimeID = "N/A";
		this.crimeLatitude = "N/A";
		this.crimeLongitude = "N/A";
	}

	public CrimeInfo(String inDate,
	          String inAddress,
	          String inDistrict,
	          String inBeat,
	          String inGrid,
	          String inDescription,
	          String inID,
	          String inLatitude,
	          String inLongitude)
	{
		this.setCrimeDate(inDate);
		this.setCrimeAddress(inAddress);
		this.setDistrict(inDistrict);
		this.setBeat(inBeat);
		this.setGrid(inGrid);
		this.setCrimeDescription(inDescription);
		this.setCrimeID(inID);
		this.setCrimeLatitude(inLatitude);
		this.setCrimeLongitude(inLongitude);
	}

	public void setCrimeDate(String indate)
	{
		this.crimeDate = indate;
	}

	public void setCrimeAddress(String inaddress)
	{
		this.crimeAddress = inaddress;
	}

	public void setDistrict(String indistrict)
	{
		this.district = indistrict;
	}

	public void setBeat(String inbeat)
	{
		this.beat = inbeat;
	}

	public void setGrid(String ingrid)
	{
		this.grid = ingrid;
	}

	public void setCrimeDescription(String indescription)
	{
		this.crimeDescription = indescription;
	}

	public void setCrimeID(String incrimeid)
	{
		this.crimeID = incrimeid;
	}

	public void setCrimeLatitude(String inlatitude)
	{
		this.crimeLatitude = inlatitude;
	}

	public void setCrimeLongitude(String inlongitude)
	{
		this.crimeLongitude = inlongitude;
	}

	public String getCrimeID()
	{
		return this.crimeID;
	}

	public String getCrimeAddress()
	{
		return this.crimeAddress;
	}
}
