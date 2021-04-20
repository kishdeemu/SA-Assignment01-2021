package covidtrackerserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class CovidTrackerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Covid Tracker Service (powered by Covid19 API)...");
		CovidTrackerPublish publisherService = new CovidTrackerPublishImpl();
		publishServiceRegistration = bundleContext.registerService(CovidTrackerPublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Covid Tracker Service (powered by Covid19 API)......Thank You!...");
		bundleContext.ungetService(serviceReference);
	}

}
