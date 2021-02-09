package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String redirect = request.getParameter("redirect");

	if ("true".equals(redirect)) {
	    String contextPath = request.getContextPath();

	    response.sendRedirect(contextPath + "/showMe");
	    return;
	}
	ServletOutputStream out = response.getOutputStream();
	out.println("<h3>Text of RedirectDemoServlet</h3>");
	out.println("- servletPath=" + request.getServletPath());

    }

}
