package com.example.demo_jstl.repository.impl;

import com.example.demo_jstl.entity.Classes;
import com.example.demo_jstl.entity.Student;
import com.example.demo_jstl.repository.BaseRepository;
import com.example.demo_jstl.repository.IClassRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassesRepository implements IClassRepository {
    @Override
    public List<Classes> findAll() {
        List<Classes> classesList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from classes;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Classes classes = new Classes(id,name);
                classesList.add(classes);
            }
        } catch (SQLException e) {
            System.out.println("lỗi query");
        }
        return classesList;
    }
}
