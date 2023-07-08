package adv_j_servlet03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adv_j_servlet03.dao.StudentsDao;
import adv_j_servlet03.dto.StudentDto;

public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	//creation of object
	StudentsDao d=new StudentsDao();
	
	boolean cond=false;//a condition to check
	
	List<StudentDto> list=d.getStudents();//calling the method present in Dao layer for fetching all the data in DB and storing in list as it returns more than one result
	for(StudentDto st:list)//iterating the list which we got
	{
	   if(st.getEmail().equals(email))//condition to check whether the email is present in DB
	{
			cond=true;//changing the condition value if found
			break;//terminating
		}
	}
	
	       if(cond==true)//if found the email now checking is done for password
	      {
		         StudentDto st=d.login(email);//calling the login method then if found the particular data storing in st
		      if(st.getPassword().equals(password))//condition to check password entered and password present in DB are matching
                 {
//			         PrintWriter p=resp.getWriter();//if yes print success
//			         p.println(" login success");
		    	  
		    	  //this RequestDispatcher is used to redirect within the application 
		    	  // 2 types forward and include
		    	  //return type is RequestDispatcher
		    	  // present in HttpServletRequest 
		    	  // using the reference variable of HttpServletRequest which is req we can access it
		    	  
//		    	  RequestDispatcher dispatcher=req.getRequestDispatcher("display.html");
//		    		dispatcher.forward(req, resp);
		    	  
		    	  
		    	  // this is used to redirect the application outside the application
		    	  // the return type is void
		    	  // present in HttpServletResponse 
		    	  // using the reference variable of HttpServletResponse that is  resp we can access it
		    	  
		    	  resp.sendRedirect("https://www.youtube.com/watch?v=JfEi8-Tkfpw&list=RDJfEi8-Tkfpw&start_radio=1");
		    	  
                 }
		      else
		        {
//			        PrintWriter p=resp.getWriter();//if not print login failed
//			        p.println("login failed");
		    	  
		    	  RequestDispatcher dispatcher=req.getRequestDispatcher("log_in.html");
		    		dispatcher.include(req, resp);
		        }
	        }
	    else
	       {
//		       PrintWriter p=resp.getWriter();//if the email id is not present 
//		       p.println("no email id");//print no id
	    	
	    	 RequestDispatcher dispatcher=req.getRequestDispatcher("log_in.html");
	    		dispatcher.include(req, resp);
	    		
	        }
	
}
}
