package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.NewService;

@Service
public class NewServiceImpl implements NewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public NewDTO save(NewDTO newDTO) {	
		//if exist  then id is null		
		NewEntity newEntity =new NewEntity();
		
		if(newDTO.getId()!=null) {
			NewEntity oldNewEntity = newRepository.getOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);			
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());		
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);		
		return newDTO;
	}
}
