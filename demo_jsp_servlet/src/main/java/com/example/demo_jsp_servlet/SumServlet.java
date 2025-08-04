package com.example.demo_jsp_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HttpServlet" ,value = "/sum")
public class SumServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("hàm này luôn chạy 1 lần duy nhất khi trước khi servlet khởi tạo");
    }

    @Override
    public void destroy() {
        System.out.println(" hàm luôn chạy 1 lần duy nhất trước khi servlet bị phá huỷ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doGet running---------");
        req.getRequestDispatcher("/form.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doPost running---------");
        // tính toán
        // lấy dữ liệu
        float num1 = Float.parseFloat(req.getParameter("number1"));
        float num2 = Float.parseFloat(req.getParameter("number2"));
        float sum = num1+num2;
        // gửi dữ liệu sang file jsp để hiển thị
        req.setAttribute("num1",num1);
        req.setAttribute("num2",num2);
        req.setAttribute("sum",sum);
        req.getRequestDispatcher("/form.jsp").forward(req,resp);

    }
}
