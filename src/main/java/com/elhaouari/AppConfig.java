package com.elhaouari;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.elhaouari.rmi.BankRmiRemote;

@Configuration
public class AppConfig {

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8082/bank");
		return exporter;
	}
	
	@Bean
	public RmiServiceExporter getRmiExporter(ApplicationContext context) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(context.getBean("rmiService"));
		exporter.setRegistryPort(1099);
		exporter.setServiceName("bk");
		exporter.setServiceInterface(BankRmiRemote.class);
		return exporter;
	}
}
