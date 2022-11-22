package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "C:\\VSCodeProjects\\Javatutoring1\\demo\\src\\Resources";

    public App() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                String inputWord = "";
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                    } else {
                        inputWord = item.getString();
                    }
                }
                File file = new File(UPLOAD_DIRECTORY + File.separator + "input.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                List<String> lines = new ArrayList<String>();
                while ((st = br.readLine()) != null) {
                    lines.add(st);
                }
                PrintWriter writer = new PrintWriter(UPLOAD_DIRECTORY + File.separator + "output.txt", "UTF-8");
                Algorythm algorythm = new Algorythm();
                for (int i = 0; i < lines.size(); i++) {
                    int count = algorythm.solution(lines.get(i), inputWord);
                    writer.println("the word " + inputWord + " can be found " + count + " times in line " + (i + 1));
                }
                writer.close();
                response.sendRedirect("output");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
    }
    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "");
        context.addServlet(new ServletHolder(new Input()), "/input");
        context.addServlet(new ServletHolder(new Output()), "/output");
        context.addServlet(new ServletHolder(new Download()), "/download");
        server.start();
        server.join();
    }
}