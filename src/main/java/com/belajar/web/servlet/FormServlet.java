package com.belajar.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Convert the URL to a URI and then to a Path
            Path path = Paths.get(FormServlet.class.getResource("/html/form.html").toURI());
            String html = Files.readString(path);
            resp.getWriter().println(html);
        } catch (URISyntaxException e) {
            throw new ServletException("Error converting URL to URI", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstName") + " " + req.getParameter("lastName");
        String hello = "Hello " + name;
        resp.getWriter().println(hello);
    }
}
