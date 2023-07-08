package adv_j_servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adv_j_servlet03.dao.StudentsDao;
import adv_j_servlet03.dto.StudentDto;

public class DeleteServlet extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  int id=Integer.parseInt(req.getParameter("id"));
		
		StudentsDao d=new StudentsDao();
		StudentDto st=d.deleteStudent(id);
		if(st!=null)
		{
			PrintWriter p=resp.getWriter();
			p.println("removed successfully...");
		}
		else
		{
			PrintWriter p=resp.getWriter();
			p.println("deletion failed...");
		}
}
}
