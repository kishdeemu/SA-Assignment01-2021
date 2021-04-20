package covidtrackerserviceproducer;

public interface CovidTrackerPublish {
	
	public int getTotalConfirmed(String countryName);
	public int getTotalDeaths(String countryName);
	public int getTotalRecovered(String countryName);

}
