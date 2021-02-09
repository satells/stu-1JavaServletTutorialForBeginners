package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/any/*")
public class AsteriskServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletOutputStream out = response.getOutputStream();

	out.println("<html>");
	out.println("<head><title>Asterisk</title></head>");

	out.println("<body>");

	out.println("<h3>URL: " + request.getRequestURL() + "</h3>");
	out.println("<h3>URI: " + request.getRequestURI() + "</h3>");

	out.println("</body>");
	out.println("<html>");

    }
}
