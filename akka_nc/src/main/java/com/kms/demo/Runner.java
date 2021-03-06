/*package com.kms.demo;


import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kms.demo.actor.WorkerActor;
import com.kms.demo.di.SpringExtension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;

@Component
public class Runner implements CommandLineRunner {

	
	private final Logger loger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ActorSystem actorSystem;
	
	@Autowired
	private SpringExtension springExtension;
	
	
	@Override
	public void run(String[] args) throws Exception {
		try{
			ActorRef workerActor = actorSystem.actorOf(springExtension.props("workerActor"), "worker-actor");
			
			workerActor.tell(new WorkerActor.Request(), null);
			workerActor.tell(new WorkerActor.Request(), null);
			workerActor.tell(new WorkerActor.Request(), null);
			FiniteDuration duration = FiniteDuration.create(1, TimeUnit.SECONDS);
			Future<Object> awaitable = Patterns.ask(workerActor, new WorkerActor.Response(), Timeout.durationToTimeout(duration));
			
			loger.info("Response: " + Await.result(awaitable, duration));
		}finally {
			actorSystem.terminate();
			Await.result(actorSystem.whenTerminated(), Duration.Inf());
		}
	}

}
*/