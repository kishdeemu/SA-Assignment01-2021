package dictionaryserviceproducer;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Dictionary Service (powered by Google Dictionary API)...");
		ServicePublish publisherService = new ServicePublishImpl();
		publishServiceRegistration = bundleContext.registerService(ServicePublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Dictionary Service (powered by Google Dictionary API)...Thank You!...");
		bundleContext.ungetService(serviceReference);
	}

}
