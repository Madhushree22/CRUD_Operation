package adv_j_servlet03.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import adv_j_servlet03.StudentServlet;
import adv_j_servlet03.dto.StudentDto;

public class StudentsDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("madhu");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();
    
    public void signIn(StudentDto s)
    {
    	et.begin();
    	em.persist(s);
    	et.commit();
    	System.out.println("done");
    }
    
    
    public StudentDto login(String email)
    {
    	Query q=em.createQuery("select a from StudentDto a where a.email=?1");
    	q.setParameter(1, email);
    	StudentDto s=(StudentDto) q.getSingleResult();
    	return s;
    }
    
    
    //to fetch the whole data present in DB
	public List<StudentDto> getStudents() {
		Query q=em.createQuery("select a from StudentDto a ");
		List<StudentDto> list=q.getResultList();
		return list;
	}
    public StudentDto updateStu(int id,String name)
    {
    	StudentDto st=em.find(StudentDto.class, id);
    	if(st!=null)
    	{
    		st.setName(name);
        	et.begin();
        	em.merge(st);
        	et.commit();
        	return st;
    	}
    	else {
    	return null;
    }
    } 
    public StudentDto getStudent(int id)
    {
    	StudentDto st=em.find(StudentDto.class, id);
    	if(st!=null)
    	{
    		return st;
    	}
    	else
    	{
    		return null;
    	}
    }
	public StudentDto deleteStudent(int id) {
		
		StudentDto st=em.find(StudentDto.class, id);
    	if(st!=null)
    	{
    		et.begin();
    		em.remove(st);
    		et.commit();
    		return st;
    	}
    	else
    	{
    		return null;
    	}
	}

}
