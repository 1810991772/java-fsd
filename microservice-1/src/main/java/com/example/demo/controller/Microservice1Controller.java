package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.proxy.PersonProxy;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Microservice1Controller {

	private final RestTemplate restTemplate;

	@GetMapping("/ms1/callms2")
	public ResponseEntity<?> callMicroService2(@RequestParam("name") String name, @RequestParam("age") int age) {
		PersonProxy proxy = restTemplate.getForObject("http://localhost:8888/MS-2-WS/ms2/" + name + "/" + age,
				PersonProxy.class);

		return ResponseEntity.ok(proxy);
	}

	{

	}

}
