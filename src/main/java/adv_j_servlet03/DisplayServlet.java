package adv_j_servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adv_j_servlet03.dao.StudentsDao;
import adv_j_servlet03.dto.StudentDto;

public class DisplayServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id=Integer.parseInt(req.getParameter("id"));
		
		StudentsDao d=new StudentsDao();
		StudentDto st=d.getStudent(id);
		if(st!=null)
		{
			PrintWriter p=resp.getWriter();
			p.println(st.getName());
			p.println(st.getEmail());
			p.println(st.getAddress());
			p.println(st.getPassword());
			
		}
		else
		{
			PrintWriter p=resp.getWriter();
			p.println("no student sorry");
			
		}
	}
		
	}


