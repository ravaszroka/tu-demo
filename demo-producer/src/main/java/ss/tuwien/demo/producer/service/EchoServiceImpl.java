package ss.tuwien.demo.producer.service;

import ss.tuwien.demo.api.EchoService;

public class EchoServiceImpl implements EchoService {
	@Override
	public String echo(String message) {
		System.out.println(message);
		return message;
	}
}
