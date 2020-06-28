package com.ganesh.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.api.models.Course;
import com.ganesh.api.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course addNewCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Integer id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public Integer deleteCourseById(Integer id) {
		courseRepository.deleteById(id);
		return id;
	}

	@Override
	public Course updaeCourse(Integer id, Course c) {
		Course cc = courseRepository.findById(id).get();
		cc.setCourseName(c.getCourseName());
		cc.setCourseDescription(c.getCourseDescription());
		courseRepository.save(cc);
		return cc;
	}


}
