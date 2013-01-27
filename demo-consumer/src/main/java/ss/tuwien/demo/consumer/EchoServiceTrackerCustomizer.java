package ss.tuwien.demo.consumer;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import ss.tuwien.demo.api.EchoService;

public class EchoServiceTrackerCustomizer implements ServiceTrackerCustomizer<EchoService, EchoService> {

	private BundleContext context;
	private Consumer consumer;
	
	EchoServiceTrackerCustomizer(BundleContext context, Consumer consumer) {
		this.context = context;
		this.consumer = consumer;
	}
	
	@Override
	public EchoService addingService(ServiceReference<EchoService> reference) {
		EchoService service = context.getService(reference);
		consumer.start(service);
		return service;
	}

	@Override
	public void modifiedService(ServiceReference<EchoService> reference, EchoService service) {
		// 	nothing to do
	}

	@Override
	public void removedService(ServiceReference<EchoService> reference, EchoService service) {
//		context.ungetService(reference);
		consumer.stop();
	}

}
