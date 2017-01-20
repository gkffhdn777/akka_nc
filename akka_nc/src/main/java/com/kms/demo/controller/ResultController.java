package com.kms.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.kms.demo.model.Message;
import com.kms.demo.service.CompletableFutureService;

@RestController
public class ResultController {

	private static final Long TIMEOUT = 1000L;
	
	private AtomicLong id= new AtomicLong(0);
	
	@Autowired
	private CompletableFutureService completableFutureService;
	
	@GetMapping(value="/async-non-blocking" , produces = MediaType.APPLICATION_JSON_VALUE)
	public DeferredResult<Message> getAyncNonBlocking(){
		DeferredResult<Message> deferred = new DeferredResult<>(TIMEOUT);
		CompletableFuture<Message> future = completableFutureService.get("async-non-blocking", id.getAndIncrement());
		future.whenComplete((result , error) -> {
			if(error != null){
				deferred.setErrorResult(error);
			}else{
				deferred.setResult(result);
			}
		});
		return deferred;
	}
}
