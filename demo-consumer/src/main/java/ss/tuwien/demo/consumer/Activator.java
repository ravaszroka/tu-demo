package ss.tuwien.demo.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import ss.tuwien.demo.api.EchoService;

public class Activator implements BundleActivator {

	private ServiceTracker<EchoService, EchoService> serviceTracker;
	
	@Override
	public void start(BundleContext context) throws Exception {
		serviceTracker = new ServiceTracker<>(context, EchoService.class, 
				new EchoServiceTrackerCustomizer(context, new Consumer()));
		serviceTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		serviceTracker.close();
	}

}
