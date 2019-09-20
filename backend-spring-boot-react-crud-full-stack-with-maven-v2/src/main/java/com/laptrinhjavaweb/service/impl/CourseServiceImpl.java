package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converer.CourseConverter;
import com.laptrinhjavaweb.dto.CourseDTO;
import com.laptrinhjavaweb.entity.CourseEntity;
import com.laptrinhjavaweb.repository.CourseRepository;
import com.laptrinhjavaweb.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courserRepository;

	@Autowired
	private CourseConverter courseConverter;

	@Override
	public CourseDTO save(CourseDTO courseDTO) {

		// if exist then id is null
		CourseEntity courseEntity = new CourseEntity();

		// edit
		if (courseDTO.getId() != -1) {
			CourseEntity oldCourseEntity = courserRepository.getOne(courseDTO.getId());
			courseEntity = courseConverter.toEntity(courseDTO, oldCourseEntity);
			courseEntity = courserRepository.save(courseEntity);
		} else {
			// new
			courseEntity.setUsername(courseDTO.getUsername());
			courseEntity.setDescription(courseDTO.getDescription());
			courseEntity = courserRepository.save(courseEntity);
			courseDTO = courseConverter.toDTO(courseEntity);
		}

		return courseDTO;
	}

	/**
	 * Override phương thức findAll của JPA
	 */
	@Override
	public List<CourseDTO> findAll() {

		List<CourseDTO> listCourseDTO = new ArrayList<>();
		List<CourseEntity> listCourseEntity = new ArrayList<>();

		listCourseEntity = courserRepository.findAll();

		for (CourseEntity courseEntity : listCourseEntity) {

			CourseDTO courseDTO = new CourseDTO();
			courseDTO = courseConverter.toDTO(courseEntity);
			listCourseDTO.add(courseDTO);
		}

		return listCourseDTO;
	}

	@Override
	public CourseDTO findById(Long id) {

		CourseDTO courseDTO = new CourseDTO();
		CourseEntity courseEntity = new CourseEntity();
		courseEntity = courserRepository.getOne(id);

		courseDTO = courseConverter.toDTO(courseEntity);

		return courseDTO;
	}

	@Override
	public CourseDTO deleteById(Long id) {

		CourseDTO courseDTO = new CourseDTO();
		CourseEntity courseEntity = new CourseEntity();
		courseEntity = courserRepository.getOne(id);
		courseDTO = courseConverter.toDTO(courseEntity);
		courserRepository.delete(courseEntity);

		return courseDTO;
	}

}
