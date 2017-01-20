package com.kms.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
	private final Logger loger = LoggerFactory.getLogger(this.getClass());
	
	public void perform(Object o){
		loger.info("prefome: {}", o.toString());
	}
}
