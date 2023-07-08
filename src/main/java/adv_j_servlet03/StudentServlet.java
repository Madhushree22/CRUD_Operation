package adv_j_servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adv_j_servlet03.dao.StudentsDao;
import adv_j_servlet03.dto.StudentDto;

public class StudentServlet extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String Email_id=req.getParameter("email");
	String Address=req.getParameter("address");
	String Password=req.getParameter("password");
	
	System.out.println(name);
	PrintWriter p=resp.getWriter();
	
	StudentDto st=new StudentDto();
	st.setName(name);
	st.setEmail(Email_id);
	st.setAddress(Address);
	st.setPassword(Password);
	
	StudentsDao d= new StudentsDao();
	d.signIn(st);
	
	
//	p.print("added");
	RequestDispatcher de=req.getRequestDispatcher("log_in.html");
	de.forward(req, resp);
}
}
