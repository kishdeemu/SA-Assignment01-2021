package weathersubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import weatherserviceproducer.WeatherServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	int option2;
	String cityName = "";

	public void start(BundleContext bundleContext) throws Exception {
		serviceReference = bundleContext.getServiceReference(WeatherServicePublish.class.getName());
		WeatherServicePublish weatherservicePublish = (WeatherServicePublish) bundleContext.getService(serviceReference);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter city name:- ");
		cityName = sc.nextLine();
		System.out.println("1. Get Weather description...");
		System.out.println("2. Get Temperature...");
		System.out.println("3. Find an example...");
		System.out.print("Choose option:- ");
		option2 = sc.nextInt();
		
		if(option2 == 1) {
			System.out.println("Description:- " + weatherservicePublish.getDesciption(cityName));
		}else if(option2 == 2) {
			System.out.println("Temperature:- " + weatherservicePublish.getTemperature(cityName));
		}else if(option2 == 3) {
			System.out.println("Humidity:- " + weatherservicePublish.getHumidity(cityName));
		}else {
			System.out.println("INVALID NUMBER!");
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Unsubscribing Weather Service...");
		bundleContext.ungetService(serviceReference);
	}

}
