package com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

@RequestMapping("/v1")
@RestController
public class MyController
{

	@Autowired
	DiscoveryClient client;

	@GetMapping("/get-me")
	public String get()
	{
		StringBuilder data = new StringBuilder();

		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
		Applications applications = registry.getApplications();

		applications.getRegisteredApplications().forEach((registeredApplication) -> {
			registeredApplication.getInstances().forEach((instance) -> {
				System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : ");

				data.append(instance.getAppName() + " (" + instance.getInstanceId() + ") /n " + instance.getIPAddr() + ":" + instance.getPort());
			});
		});

		return data.toString();
	}
}
