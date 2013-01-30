package ss.tuwien.demo.consumer;

import ss.tuwien.demo.api.EchoService;


public class Consumer implements Runnable {

	private volatile boolean run;
	private EchoService service;
	
	public void start(EchoService service) {
		run = true;
		this.service = service;
		new Thread(this).start();
	}
	
	public void stop() {
		run = false;
		this.service = null;
	}
	
	@Override
	public void run() {
		while (run) {
			service.echo("BLAH BLAH");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// ignore
			}
		}
	}
	
}
