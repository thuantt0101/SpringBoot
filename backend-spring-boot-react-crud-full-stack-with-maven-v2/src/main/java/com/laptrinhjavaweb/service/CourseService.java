package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CourseDTO;

public interface CourseService {
	
	CourseDTO save(CourseDTO courseDTO);
	List<CourseDTO> findAll();
	CourseDTO findById(Long id);
	CourseDTO deleteById(Long id);
	
}
