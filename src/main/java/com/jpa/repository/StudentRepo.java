package com.jpa.repository;

import com.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {

    Student findByName(String studentName);
}
