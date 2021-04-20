package bmiserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class BMIServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting BMI Service...");
		BMIServicePublish publisherService = new BMIServicePublishImpl();
		publishServiceRegistration = bundleContext.registerService(BMIServicePublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Starting BMI Service......Thank You!...");
		bundleContext.ungetService(serviceReference);
	}

}
