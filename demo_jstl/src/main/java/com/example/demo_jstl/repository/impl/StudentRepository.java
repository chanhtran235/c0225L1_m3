package com.example.demo_jstl.repository.impl;

import com.example.demo_jstl.dto.StudentDto;
import com.example.demo_jstl.entity.Student;
import com.example.demo_jstl.repository.BaseRepository;
import com.example.demo_jstl.repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final String SELECT_ALL = "select s.id,s.name,s.gender,s.score,c.name as class_name from students s join classes c on s.class_id=c.id;";
    private final String INSERT_INTO = "insert into students(name,gender,score,class_id) values(?,?,?,?);";
    private final String DELETE_BY_ID = "call delete_by_id(?);";
    private final String SEARCH_NAME_CLASS = "select s.id,s.name,s.gender,s.score,c.name as class_name \n" +
            "from students s join classes c on s.class_id=c.id\n" +
            "where s.name like concat('%',?,'%') and c.id = ?;";
    private final String SEARCH_NAME = "select s.id,s.name,s.gender,s.score,c.name as class_name \n" +
            "from students s join classes c on s.class_id=c.id\n" +
            "where s.name like concat('%',?,'%');";
    @Override
    public List<StudentDto> findAll() {
        List<StudentDto> studentList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               boolean gender = resultSet.getBoolean("gender");
               float score = resultSet.getFloat("score");
               String className = resultSet.getString("class_name");
               studentList.add(new StudentDto(id,name,gender,score,className));
           }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return studentList;
    }

    @Override
    public List<StudentDto> searchByNameAndClassId(String searchName, String classId) {
        List<StudentDto> studentList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME_CLASS);
            preparedStatement.setString(1,searchName);
            preparedStatement.setString(2,classId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                studentList.add(new StudentDto(id,name,gender,score,className));
            }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return studentList;
    }

    @Override
    public List<StudentDto> searchByName(String searchName) {
        List<StudentDto> studentList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);
            preparedStatement.setString(1,searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                studentList.add(new StudentDto(id,name,gender,score,className));
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
