package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController
public class MicroService2Controller {

	@GetMapping("/ms2/{name}/{age}")
	public Person createPerson(@PathVariable("name") String name, @PathVariable("age") int age) {
		return Person.builder().name(name).age(age).build();
	}

}
