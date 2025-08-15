package com.example.demo_jstl.service;

import com.example.demo_jstl.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add(Student student);
    boolean delete(int id);
}
