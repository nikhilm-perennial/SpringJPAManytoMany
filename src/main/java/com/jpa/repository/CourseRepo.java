package com.jpa.repository;

import com.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {

    Course findByName(String courseName);
}
