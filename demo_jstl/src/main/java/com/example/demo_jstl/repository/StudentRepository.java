package com.example.demo_jstl.repository;

import com.example.demo_jstl.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh",true,4.5f));
        studentList.add(new Student(2,"chánh2",false,9.0f));
        studentList.add(new Student(3,"chánh3",true,7.0f));
        studentList.add(new Student(4,"chánh4",true,6.0f));
        studentList.add(new Student(5,"chánh5",true,5.0f));
    }
    @Override
    public List<Student> findAll() {
        // keets nối DB
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        studentList.add(student);
        return true;
    }
}
