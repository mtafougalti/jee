package com.mt.jee.servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="helloWorldServlet", urlPatterns = {"*.do"})
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1271960905380863262L;

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet HelloWorldServlet initialized ");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet is called from HelloWorldServlet ");
		String name = request.getParameter("name");
//		name = name == null ? "World" : name;
//		response.getWriter().print("<h3> Hello " + name + " ! </h3>");
		
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/hello.jsp");
//		dispatcher.forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/views/hello.jsp?name="+name);


	}

}
