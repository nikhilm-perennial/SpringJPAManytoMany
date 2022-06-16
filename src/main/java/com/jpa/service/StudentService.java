package com.jpa.service;

import com.jpa.dto.StudentDTO;
import com.jpa.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudent();

    String deleteStudent(Long studentId);

}
