package com.example.demo_jstl.service.impl;

import com.example.demo_jstl.entity.Classes;
import com.example.demo_jstl.repository.impl.ClassesRepository;
import com.example.demo_jstl.repository.IClassRepository;
import com.example.demo_jstl.service.IClassesService;

import java.util.List;

public class ClassesService implements IClassesService {
    private IClassRepository classRepository = new ClassesRepository();
    @Override
    public List<Classes> findAll() {
        return classRepository.findAll();
    }
}
