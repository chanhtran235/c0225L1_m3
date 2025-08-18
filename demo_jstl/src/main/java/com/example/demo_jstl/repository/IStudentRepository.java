package com.example.demo_jstl.repository;

import com.example.demo_jstl.dto.StudentDto;
import com.example.demo_jstl.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll();
    boolean add(Student student);
    boolean delete(int id);
}
