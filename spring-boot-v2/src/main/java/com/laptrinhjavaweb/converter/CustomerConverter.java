package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

//biểu thị đây là một component được tự động scan
@Component
public class CustomerConverter {

	public CustomerEntity toEntity(CustomerDTO dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());

		return entity;
	}

	public CustomerDTO toDTO(CustomerEntity entity) {

		CustomerDTO dto = new CustomerDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}

		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());

		return dto;
	}
	
	
	public CustomerEntity toEntity(CustomerDTO dto, CustomerEntity entity) {
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		return entity;
	}
	
}
