package com.jpa.service;

import com.jpa.dto.StudentDTO;
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
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;
//    @Override
//    public Student saveStudent(Student student) {
////        Student student1 = new Student();
////        student1.setName(student.getName());
////        student1.setCourse(student.getCourse());
////        student1.getCourse()
////                .addAll(student
////                        .getCourse()
////                        .stream().map(c -> {
////                            Course course1 = courseService.findCourseById(c.getCourseId());
////                            course1.getStudent().add(student1);
////                            return course1;
////                        }).toList());
//        return studentRepo.save(student);
//    }

    @Transactional
    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        mapDtoToEntity(studentDTO,student);
        Student saveStudent = studentRepo.save(student);
        return mapEntityToDto(saveStudent);
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> students = studentRepo.findAll();
        students.stream().forEach(student -> {
            StudentDTO studentDTO = mapEntityToDto(student);
            studentDTOS.add(studentDTO);
        });
        return studentDTOS;
    }

    @Override
    public String deleteStudent(Long studentId) {
        return null;
    }


    private void mapDtoToEntity(StudentDTO studentDTO,Student student){
        student.setName(studentDTO.getName());
        if(null == student.getCourses()){
            student.setCourses(new ArrayList<>());
        }
        studentDTO.getCourses().stream().forEach(s -> {
            Course course = courseRepo.findByName(s);
            if (null == course){
                course = new Course();
                course.setStudent(new ArrayList<>());
            }
            course.setName(s);
            student.addCourse(course);
        });
    }

    private StudentDTO mapEntityToDto(Student student){
        StudentDTO responseDTO = new StudentDTO();
        responseDTO.setName(student.getName());
        responseDTO.setId(student.getStudentId());
        responseDTO.setRollno(student.getRollno());
        responseDTO.setCourses(student.getCourses().stream().map(Course::getName).toList());
        return responseDTO;
    }
}















