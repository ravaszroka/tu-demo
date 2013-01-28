package ss.tuwien.demo.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import ss.tuwien.demo.api.EchoService;
import ss.tuwien.demo.producer.service.EchoServiceImpl;

public class Activator implements BundleActivator {

//	private ServiceRegistration<EchoService> serviceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
//		serviceRegistration = context.registerService(EchoService.class, new EchoServiceImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
//		serviceRegistration.unregister();
	}

}
