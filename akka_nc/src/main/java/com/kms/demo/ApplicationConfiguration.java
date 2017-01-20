package com.kms.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kms.demo.di.SpringExtension;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;

@Configuration
public class ApplicationConfiguration {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private SpringExtension springExtension;
	
	//액서 시스템 생성 
	//보통은 한개만 생성 
	//액터이름은 클러스터 참여시 에는 의미가 있음
	@Bean
	public ActorSystem actorSuystem(){
		ActorSystem system = ActorSystem.create("demo-actor-system", AkkaConfig());
		springExtension.init(applicationContext);
		return system;
	}
	
	@Bean
	public Config AkkaConfig(){
		return ConfigFactory.load();
	}
}
