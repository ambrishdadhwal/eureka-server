package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan("com.server")
public class EurekaServerApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
