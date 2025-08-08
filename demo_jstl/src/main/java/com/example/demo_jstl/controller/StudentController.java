package com.example.demo_jstl.controller;

import com.example.demo_jstl.entity.Student;
import com.example.demo_jstl.service.IStudentService;
import com.example.demo_jstl.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(req,resp);
                break;
            case "delete":
                break;
            default:
                showList(req,resp);

        }


    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/view/student/add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> studentList = studentService.findAll();
        req.setAttribute("studentList", studentList);
        try {
            req.getRequestDispatcher("/view/student/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                save(req,resp);
                break;
            case "delete":
                break;
            default:
        }

    }


    private void save(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        float score = Float.parseFloat(req.getParameter("score"));
        Student student = new Student(id,name,gender,score);
        boolean isAddSuccess = studentService.add(student);
        String mess = "";
        if (isAddSuccess){
            mess = "Add success";
        }else {
            mess = "No success";
        }
        try {
            resp.sendRedirect("/students?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
