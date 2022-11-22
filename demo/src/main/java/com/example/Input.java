package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class Input extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Input() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form action='input' method='post' enctype='multipart/form-data'>");
        out.println("<input type='file' name='file'/>");
        out.println("<input type='text' name='inputWord'/>");
        out.println("<input type='submit' value='submit'/>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        response.sendRedirect("output");
    }
}