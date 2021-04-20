package covidtrackersubscriber;

import covidtrackerserviceproducer.CovidTrackerPublish;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	int option3;
	String countryName = "";

	public void start(BundleContext bundleContext) throws Exception {
		serviceReference = bundleContext.getServiceReference(CovidTrackerPublish.class.getName());
		CovidTrackerPublish covidTrackerPublish = (CovidTrackerPublish) bundleContext.getService(serviceReference);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter country name:- ");
		countryName = sc.nextLine();
		System.out.println("1. Get Total Confirmed cases in "+countryName+"...");
		System.out.println("2. Get Total Recovered in "+countryName+"...");
		System.out.println("3. Get Total Deaths in "+countryName+"...");
		System.out.print("Choose option:- ");
		option3 = sc.nextInt();
		
		if(option3 == 1) {
			System.out.println("Total Confirmed Cases in "+countryName+":- " + covidTrackerPublish.getTotalConfirmed(countryName));
		}else if(option3 == 2) {
			System.out.println("Total Recovered Patients in "+countryName+":- " + covidTrackerPublish.getTotalRecovered(countryName));
		}else if(option3 == 3) {
			System.out.println("Total Deaths in "+countryName+":- " + covidTrackerPublish.getTotalDeaths(countryName));
		}else {
			System.out.println("INVALID NUMBER!");
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Unsubscribing Covid Tracker Service...");
		bundleContext.ungetService(serviceReference);
	}

}
