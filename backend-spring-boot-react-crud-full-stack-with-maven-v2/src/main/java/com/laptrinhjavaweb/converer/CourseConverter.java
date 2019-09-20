package com.laptrinhjavaweb.converer;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CourseDTO;
import com.laptrinhjavaweb.entity.CourseEntity;

@Component
public class CourseConverter {

	
	
	/**
	 * new
	 * @param courseDTO
	 * @return CourseEntity
	 * @author tranthanhthuan
	 */
	public CourseEntity toEntity(CourseDTO courseDTO) {
		
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setUsername(courseDTO.getUsername());
		courseEntity.setDescription(courseDTO.getDescription());
		
		return courseEntity;
	}
	
	
	/**
	 * Edit
	 * @param courseDTO : DTO Course
	 * @param courseEntity : Entity Course
	 * @return : CourseEntity
	 * @author tranthanhthuan
	 */
	public CourseEntity toEntity(CourseDTO courseDTO,CourseEntity courseEntity) {		
		courseEntity.setUsername(courseDTO.getUsername());
		courseEntity.setDescription(courseDTO.getDescription());
		return courseEntity;
	}
	
	
	public CourseDTO toDTO(CourseEntity courseEntity) {
		CourseDTO courseDTO = new CourseDTO();
	
		if(courseEntity.getId()!=null) {
			courseDTO.setId(courseEntity.getId());
		}
		
		courseDTO.setUsername(courseEntity.getUsername());
		courseDTO.setDescription(courseEntity.getDescription());
		
		return courseDTO;
	}
	
	
}
