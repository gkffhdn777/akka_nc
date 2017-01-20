package com.kms.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kms.demo.di.SpringExtension;
import com.kms.demo.model.Message;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

@Service
public class CompletableFutureService {

	@Autowired
	private ActorSystem actorSystem;
	
	@Autowired
	private SpringExtension springExtension;
	
	public CompletableFuture<Message> get(String payload, Long id){
		CompletableFuture<Message> future = new CompletableFuture<Message>();
		ActorRef workerActor = actorSystem.actorOf(springExtension.props("workerActor", future), "worker-actor");
		workerActor.tell(new Message(payload, id), ActorRef.noSender());
		return future;
	}
}
