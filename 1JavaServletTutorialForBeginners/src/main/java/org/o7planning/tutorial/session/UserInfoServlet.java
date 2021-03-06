package org.o7planning.tutorial.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.tutorial.beans.Constants;
import org.o7planning.tutorial.beans.UserInfo;

@WebServlet(urlPatterns = "/userInfo")
public class UserInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletOutputStream out = response.getOutputStream();

	HttpSession session = request.getSession();
	UserInfo loginedInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
	if (loginedInfo == null) {
	    // ==> /ServletTutorial/login
	    response.sendRedirect(this.getServletContext().getContextPath() + "/login");
	    return;
	}

	out.println("<html>");
	out.println("<head><title>Session example</title></head>");

	out.println("<body>");

	out.println("<h3>User Info:</h3>");

	out.println("<p>User Name:" + loginedInfo.getUserName() + "</p>");
	out.println("<p>Country:" + loginedInfo.getCountry() + "</p>");
	out.println("<p>Post:" + loginedInfo.getPost() + "</p>");

	out.println("</body>");
	out.println("<html>");

    }

}
