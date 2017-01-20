package com.kms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.DynamicPropertyFactory;

@SpringBootApplication
public class AkkaNcApplication {

	public static void main(String[] args) {
		 ConcurrentCompositeConfiguration myConfiguration = 
		            (ConcurrentCompositeConfiguration) DynamicPropertyFactory.getInstance().getBackingConfigurationSource();
		
		 SpringApplication.run(AkkaNcApplication.class, args);
	}
}
