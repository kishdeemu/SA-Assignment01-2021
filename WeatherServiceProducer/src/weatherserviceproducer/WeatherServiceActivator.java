package weatherserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class WeatherServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Weather Service (powered by Open Weather API)...");
		WeatherServicePublish publisherService = new WeatherServicePublishImpl();
		publishServiceRegistration = bundleContext.registerService(WeatherServicePublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Weather Service (powered by Open Weather API)...Thank You!...");
		bundleContext.ungetService(serviceReference);
	}


}
