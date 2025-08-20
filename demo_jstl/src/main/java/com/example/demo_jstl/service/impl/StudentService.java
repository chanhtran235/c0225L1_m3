package com.example.demo_jstl.service.impl;

import com.example.demo_jstl.dto.StudentDto;
import com.example.demo_jstl.entity.Student;
import com.example.demo_jstl.repository.IStudentRepository;
import com.example.demo_jstl.repository.impl.StudentRepository;
import com.example.demo_jstl.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentDto> searchByNameAndClassId(String searchName, String id) {

        if ("".equals(id)){
            return studentRepository.searchByName(searchName);
        }
        return studentRepository.searchByNameAndClassId(searchName,id);
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }
}
