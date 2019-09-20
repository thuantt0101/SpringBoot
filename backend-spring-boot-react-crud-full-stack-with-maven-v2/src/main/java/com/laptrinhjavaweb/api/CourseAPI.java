package com.laptrinhjavaweb.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laptrinhjavaweb.dto.CourseDTO;
import com.laptrinhjavaweb.service.CourseService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CourseAPI {

	@Autowired
	private CourseService courseService;

	@GetMapping(value = "/instructors/{username}/courses")
	public List<CourseDTO> getAllCourses(@PathVariable String username) {
		System.out.println("Get all courses is called");
		return courseService.findAll();
	}

	// ResponseEntity.noContent().build() - If Request is successful, return no
	// content back
	// ResponseEntity.notFound().build() - If delete failed, return error - resource
	// not found.
	//Post Request Method to create a new course for a specific instructor
	@PostMapping(value = "/instructors/{username}/courses")
	public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody CourseDTO courseDTO) {
		
		System.out.println("Created new course is called");

		CourseDTO createdCourse = courseService.save(courseDTO);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	// Get Request Method exposing the details of a specific course taught by a
	// specific instructor
	@GetMapping("/instructors/{username}/courses/{id}")
	public CourseDTO getCourse(@PathVariable String username, @PathVariable long id) {
		System.out.println("Get specific course is called");		
			
		CourseDTO courseDTO = new CourseDTO();
		
		courseDTO =  courseService.findById(id);
		
		System.out.println(courseDTO.getUsername());
		System.out.println(courseDTO.getDescription());
		
		return courseDTO;
		
	}

	// delete
	@DeleteMapping(value = "/instructors/{username}/courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id) {

		System.out.println("Delete specific course is called");
		CourseDTO courseDTO = courseService.deleteById(id);

		if (courseDTO != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}
	

	//Put Request Method to update the course details of a specific course taught by a specific instructor
	@PutMapping("/instructors/{username}/courses/{id}")
	public ResponseEntity<CourseDTO> updateCourse(@PathVariable String username, @PathVariable long id,
			@RequestBody CourseDTO course) {
		System.out.println("put is called");
		CourseDTO courseUpdated = courseService.save(course);

		return new ResponseEntity<CourseDTO>(course, HttpStatus.OK);
	}

}
