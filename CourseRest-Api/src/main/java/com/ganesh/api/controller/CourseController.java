package com.ganesh.api.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.api.models.Course;
import com.ganesh.api.repository.CourseRepository;
import com.ganesh.api.services.CourseService;

import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CourseController {
	
	private CourseService courseService;
	
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	@GetMapping("/")
	public String gretting() {
		return "Wel Come To Spring World!!";
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourse(){
		  List<Course> list = courseService.getAllCourse();
		  return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/courses/course")
	public ResponseEntity<Course> createNewCourse(@RequestBody Course course){
		  if (StringUtils.isEmpty(course) || course == null) {
			    return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
			  }
		Course courses = courseService.addNewCourse(course);
		return new ResponseEntity<Course>(courses,HttpStatus.CREATED);
	}
	
	@PutMapping("/courses/{id}/course")
	public ResponseEntity<Course> updateCourseById(@PathVariable Integer id, @RequestBody Course cc){
		 if (StringUtils.isEmpty(id) || id == null) {
			 if(StringUtils.isEmpty(cc) || cc == null) {
				  return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST); 
			    }
			  }
		 Course cour = courseService.updaeCourse(id, cc);
		return new ResponseEntity<Course>(cour, HttpStatus.OK);
	}
	

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
		if(StringUtils.isEmpty(id) || id == null) {
			return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
		}
		Course cour = courseService.getCourseById(id);
		return new ResponseEntity<Course>(cour, HttpStatus.OK);
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable Integer id){
		 if (StringUtils.isEmpty(id) || id == null) {
			    return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
			  }
		 courseService.deleteCourseById(id);
		return new ResponseEntity<>("Deleted Course Successfully", HttpStatus.OK);
	}

}
