package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.Course;
import com.laptrinhjavaweb.service.impl.CoursesHardcodedService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CourseResource {

	
	@Autowired
	private CoursesHardcodedService courseManagementService;

	@GetMapping("/instructors/{username}/courses")
	public List<Course> getAllCourses(@PathVariable String username) {
		return courseManagementService.findAll();
	}
}
