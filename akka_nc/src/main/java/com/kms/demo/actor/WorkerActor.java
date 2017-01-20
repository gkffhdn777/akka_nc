package com.kms.demo.actor;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kms.demo.model.Message;
import com.kms.demo.service.BusinessService;

import akka.actor.UntypedActor;


@Component
@Scope("prototype")
public class WorkerActor extends UntypedActor{
	
	
	@Autowired
	private BusinessService businessService;
	
	final private CompletableFuture<Message> future;
	
	public WorkerActor(CompletableFuture<Message> future) {
		this.future = future;
	}

	@Override
	public void onReceive(Object message) throws Throwable {
		businessService.perform(this + " / " + message);
		System.out.println("future : "+future);
		if(message instanceof Message){
			System.out.println("[message] : "+message);
			future.complete((Message)message);
		}else{
			unhandled(message);
		}
		getContext().stop(self());
		
	}

}
