package com.example.demo_jstl.repository;

import com.example.demo_jstl.entity.Classes;

import java.util.List;

public interface IClassRepository {
    List<Classes> findAll();
}
