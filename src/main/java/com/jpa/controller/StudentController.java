package com.jpa.controller;

import com.jpa.dto.CourseDTO;
import com.jpa.dto.StudentDTO;
import com.jpa.service.CourseService;
import com.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/students")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/courses")
    public List<CourseDTO> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping("/courses")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO){
        return courseService.saveCourse(courseDTO);
    }

    @DeleteMapping("/courses/{courseId}")
      public void deleteCourse(@PathVariable String courseId){
         courseService.deleteCourseById(Long.valueOf(courseId));
      }
}
