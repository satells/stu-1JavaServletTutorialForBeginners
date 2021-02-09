package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String emailSupport1;
    private String emailSupport2;

    public InitParamServlet() {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
	super.init(config);

	this.emailSupport1 = config.getInitParameter("emailSupport1");
	this.emailSupport2 = config.getInitParameter("emailSupport2");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String emailSupport = this.getServletConfig().getInitParameter("emailSupport1");
	String emailSupportx = this.getServletConfig().getInitParameter("emailSupport2");
	ServletOutputStream out = response.getOutputStream();
	out.println("<html>");
	out.println("<head><title>Init Param</title></head>");

	out.println("<body>");
	out.println("<h3>Init Param</h3>");
	out.println("<p>emailSupport1 = " + this.emailSupport1 + " - " + emailSupport + "</p>");
	out.println("<p>emailSupport2 = " + emailSupport2 + " - " + emailSupportx + "</p>");
	out.println("</body>");
	out.println("<html>");

    }

}
