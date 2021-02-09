package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/showMe")
public class ShowMeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletOutputStream out = response.getOutputStream();
	out.println("<html>");
	out.println("<body>");

	String mensagem = (String) request.getAttribute("mensagem");

	if (mensagem == null) {
	    out.println("sem mensagem");
	} else {
	    out.println(mensagem);

	}

	out.println("</body>");
	out.println("</html>");
    }

}
