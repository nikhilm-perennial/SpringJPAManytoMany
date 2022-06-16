package com.jpa.service;

import com.jpa.dto.CourseDTO;
import com.jpa.model.Course;
import com.jpa.model.Student;
import com.jpa.repository.CourseRepo;
import com.jpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;

    @Transactional
    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        mapDtoToEntity(courseDTO,course);
        Course savedcourse = courseRepo.save(course);
        return mapEntityToDto(savedcourse);
    }

    @Override
    public Course findCourseById(Long courseId) {
        return null;
    }

    @Override
    public List<CourseDTO> getAllCourse() {
        List<CourseDTO> courseDtos = new ArrayList<>();
        List<Course> courses = courseRepo.findAll();
        courses.stream().forEach(course -> {
            CourseDTO courseDto = mapEntityToDto(course);
            courseDtos.add(courseDto);
        });
        return courseDtos;
    }

//    @Override
//    public List<CourseDTO> getAllCourse() {
//        return null;
//    }

    @Override
    public void deleteCourseById(Long courseId) {

    }

    private void mapDtoToEntity(CourseDTO courseDTO,Course course){
        course.setName(courseDTO.getName());
        if (null == course.getStudent()){
            course.setStudent(new ArrayList<>());
        }
        courseDTO.getStudents().stream().forEach(s -> {
            Student student = studentRepo.findByName(s);
            if (null == student){
                student = new Student();
                student.setCourses(new ArrayList<>());
            }
            student.setName(s);
            student.addCourse(course);
        });
    }

    private CourseDTO mapEntityToDto(Course course) {
        CourseDTO responseDto = new CourseDTO();
        responseDto.setName(course.getName());
        responseDto.setId(course.getCourseId());
        responseDto.setStudents(course.getStudent().stream().map(Student::getName).toList());
        return responseDto;
    }
}














