package com.jpa.service;

import com.jpa.dto.CourseDTO;
import com.jpa.model.Course;
import com.jpa.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseDTO saveCourse(CourseDTO courseDTO);
    Course findCourseById(Long courseId);
    List<CourseDTO> getAllCourse();
    void deleteCourseById(Long courseId);
}
