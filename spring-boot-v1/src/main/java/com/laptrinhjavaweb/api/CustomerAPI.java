package com.laptrinhjavaweb.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CustomerDTO;

@RestController
public class CustomerAPI {

	@PostMapping(value = "/customer")
	public CustomerDTO createNew(@RequestBody CustomerDTO model) {
		System.out.println("This is post method and return customer dto");
		return model;
	}
}
