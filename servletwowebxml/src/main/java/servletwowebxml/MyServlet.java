package servletwowebxml;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class MyServlet extends HttpServlet {
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	String name=request.getParameter("name1");
	String email=request.getParameter("email1");
//	printwriter for printing in browser and system.out in console
	PrintWriter out=response.getWriter();
	out.println("name "+name);
	out.println("email "+ email);
	
	//forward ko lagi use request dispatcher
	
	//redirect changes url
	response.sendRedirect("https://www.google.com/search?q="+name);
}

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	String name=request.getParameter("name1");
	String email=request.getParameter("email1");

	//forward ko lagi use request dispatcher
	if(name.equals("dashain") && email.equals("dash")) {
		request.setAttribute("name", name);
		RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
		rd.forward(request, response);
	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	}
	

}
}
