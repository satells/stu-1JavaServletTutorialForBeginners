package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String forward = request.getParameter("forward");

	if ("true".equals(forward)) {
	    request.setAttribute("mensagem", "Enviado do servlet: " + request.getRequestURL());

	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showMe");
	    requestDispatcher.forward(request, response);

	    return;
	}
	ServletOutputStream out = response.getOutputStream();
	out.println("<html>");
	out.println("<body>");
	out.println(request.getServletPath());
	out.println("</body>");
	out.println("</html>");

    }

}
