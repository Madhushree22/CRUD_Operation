package adv_j_servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adv_j_servlet03.dao.StudentsDao;
import adv_j_servlet03.dto.StudentDto;

public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		//creation of object
		StudentsDao d=new StudentsDao();
		StudentDto st=d.updateStu(id, name);
		if(st!=null)
		{
			PrintWriter p=resp.getWriter();
			p.println("updated");
		}
		else
		{
			PrintWriter p=resp.getWriter();
			p.println("failure");
			
		}
		
	}

}
