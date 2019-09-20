package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/customer")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO model) {

		model = customerService.save(model);
		return model;
	}

}
