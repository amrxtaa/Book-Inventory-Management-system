package com.bim.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BimService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String fetchData() {
		String apiUrl="http:localhost:9999/api";
		return restTemplate.getForObject(apiUrl,String.class);
	}
}
