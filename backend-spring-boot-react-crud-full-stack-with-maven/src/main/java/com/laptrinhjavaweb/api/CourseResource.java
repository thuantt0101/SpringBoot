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

import com.laptrinhjavaweb.entity.Course;
import com.laptrinhjavaweb.service.impl.CoursesHardcodedService;


//Trước khi có tiêu chuẩn về CORS, thì không có cách nào để một trang web gửi request thông 
//qua trình duyệt đến một domain khác.

//Trong trường hợp đơn giản nhất, phía client (tức là cái web app chạy ở browser đó) sẽ tạo request
//GET, POST, PUT, HEAD, etc để yêu cầu server làm một việc gì đó. Những request này sẽ được đính kèm một header tên là Origin để chỉ định origin của 
//client code (giá trị của header này chính là domain của trang web).

//xem them ve Cross Origin https://viblo.asia/p/tim-hieu-ve-cross-origin-resource-sharing-cors-Az45bGWqKxY
//@CrossOrigin(origins = { “http://localhost:3000”, “http://localhost:4200” }) - Allow requests from specific origins
//We will use 3000 to run React and Vue JS apps, and we use 4200 to run Angular apps.
//Hence we are allowing requests from both ports.

//@PathVariable: Defining the variables for Path Variables
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CourseResource {

	@Autowired
	private CoursesHardcodedService courseManagementService;

	//Get Request Method exposing the list of courses taught by a specific instructor
	@GetMapping("/instructors/{username}/courses")
	public List<Course> getAllCourses(@PathVariable String username) {
		System.out.println("get all is called");
		return courseManagementService.findAll();
	}

	
	//Get Request Method exposing the details of a specific course taught by a specific instructor
	@GetMapping("/instructors/{username}/courses/{id}")
	public Course getCourse(@PathVariable String username, @PathVariable long id) {
		System.out.println("get one is called");
		return courseManagementService.findById(id);
	}

	//Delete Request Method to delete a course belonging to a specific instructor
	@DeleteMapping("/instructors/{username}/courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id) {

		Course course = courseManagementService.deleteById(id);
		System.out.println("delete is called");

		if (course != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	//Put Request Method to update the course details of a specific course taught by a specific instructor
	@PutMapping("/instructors/{username}/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable String username, @PathVariable long id,
			@RequestBody Course course) {
		System.out.println("put is called");
		Course courseUpdated = courseManagementService.save(course);

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	//Post Request Method to create a new course for a specific instructor
	@PostMapping("/instructors/{username}/courses")
	public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody Course course) {
				
		System.out.println("post is called");
		Course createdCourse = courseManagementService.save(course);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
