package com.example.demo_jstl.repository.impl;

import com.example.demo_jstl.entity.Student;
import com.example.demo_jstl.repository.BaseRepository;
import com.example.demo_jstl.repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final String SELECT_ALL = "select * from students;";
    private final String INSERT_INTO = "insert into students(name,gender,score,class_id) values(?,?,?,?);";
    private final String DELETE_BY_ID = "call delete_by_id(?);";
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               boolean gender = resultSet.getBoolean("gender");
               float score = resultSet.getFloat("score");
               int classId  = resultSet.getInt("class_id");
               Student student = new Student(id,name,gender,score,classId);
               studentList.add(student);
           }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        try( Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getScore());
            preparedStatement.setInt(4,student.getClassId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi query");
            return false;
        }

    }

    @Override
    public boolean delete(int id) {

        try( Connection connection = BaseRepository.getConnectDB();) {
            CallableStatement callableStatement = connection.prepareCall(DELETE_BY_ID);
            callableStatement.setInt(1,id);
            int effectRow = callableStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi query");
            return false;
        }
    }
}
