package com.ganesh.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.api.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
   
}
