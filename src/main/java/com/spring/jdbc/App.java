package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App {

	public static void main(String[] args) {
		System.out.println("Program Started....");
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		
			StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
			
//			Student s=new Student();
//			s.setId(4);
//			s.setName("Rushikesh Yadav");
//			s.setCity("Barshi");
//			
//			int result=studentDao.insert(s);
//			System.out.println("student added "+result);
			
			
			// update
//			Student s=new Student();
//			s.setId(4);
//			s.setName("Gajanan Sawle");
//			s.setCity("Hingoli");
//			
//			int result=studentDao.change(s);
//			System.out.println("Changed "+result);
			
			// update if id is not present automatically add in table 
//			Student s=new Student();
//			s.setId(5);
//			s.setName("Rushikesh Yadav");
//			s.setCity("Barshi");
//			
//			int result=studentDao.insert(s);
//			System.out.println("student added "+result);
			
//			// delete
//			int result=studentDao.delete(5);
//			System.out.println("delete "+result);
			
//			// call single student using RowMapper
//			Student s=studentDao.getStudent(2);
//			System.out.println(s);
//	
			// call  students using RowMapper
			List<Student> students=studentDao.getAllStudent();
			for(Student s: students)
			{
				System.out.println(s);
			}
						
	}
}
