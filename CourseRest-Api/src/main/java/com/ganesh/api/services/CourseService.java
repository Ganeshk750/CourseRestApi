package com.ganesh.api.services;

import java.util.List;

import com.ganesh.api.models.Course;

public interface CourseService {
	
	public Course addNewCourse(Course course);
	public List<Course> getAllCourse();
	public Course getCourseById(Integer id);
	public Course updaeCourse(Integer id, Course c);
	public Integer deleteCourseById(Integer id);
	
	

}
