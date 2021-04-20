package bmisubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import bmiserviceproducer.BMIServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	float height, weight;
	float bmi;
	
	public void start(BundleContext bundleContext) throws Exception {
		serviceReference = bundleContext.getServiceReference(BMIServicePublish.class.getName());
		BMIServicePublish covidTrackerPublish = (BMIServicePublish) bundleContext.getService(serviceReference);
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter height in m:- ");
		height = sc.nextFloat();
		System.out.println("Please enter weight in Kg:- ");
		weight = sc.nextFloat();
		bmi = covidTrackerPublish.getBMI(weight, height);
		System.out.println("Your BMI value is " + bmi + " and " + covidTrackerPublish.getResult(bmi));
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Unsubscribing BMI Service...");
		bundleContext.ungetService(serviceReference);
	}

}
