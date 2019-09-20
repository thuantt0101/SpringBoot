package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		if(customerDTO.getId()!=null) {
			CustomerEntity oldCustomer = customerRepository.getOne(customerDTO.getId());
			customerEntity = customerConverter.toEntity(customerDTO,oldCustomer);						
		}else {
			customerEntity = customerConverter.toEntity(customerDTO);
		}
		
		customerEntity = customerRepository.save(customerEntity);
		return customerConverter.toDTO(customerEntity);
	}
}
