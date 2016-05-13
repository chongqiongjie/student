package service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.Students;
import service.StudentsDao;

public class TestStudentsDaoImpl {
	
	@Test
	public void testQueryAllStudents(){
		StudentsDao sdao = new StudentsDaoImpl();
		 List<Students> list = sdao.queryAllStudents();
		 
		 for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i));
		 }
		 
		 
	}
	
	/*
	@Test
	 public void testGetNewSid(){
		 StudentsDaoImpl sdaoi = new StudentsDaoImpl();
		 System.out.println(sdaoi.getNewSid());
	 }
	*/
	
	@Test
	public void testAddStudents(){
		Students s = new Students();
		s.setSname("xixi");
		s.setGender("ÄÐ");
		s.setBirthday(new Date());
		s.setAddress("½­ËÕ");
		StudentsDao sdao = new StudentsDaoImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
		
		
		
		
	}
	
}
