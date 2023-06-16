package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudentDaoImpl implements StudentDao {

		private JdbcTemplate jdbcTemplate;
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
	public int insert(Student student) {
		// insert query
		String q="insert into student(id,name,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(q,student.getId(),student.getName(),student.getCity());
		return r;
	}

	

	public int change(Student student) { 
		// updating data
		String q="update student set name=?, city=? where id=?";
		this.jdbcTemplate.update(q,student.getName(),student.getCity(),student.getId());
		return 0;
	}

	public int delete(int studentId) {
		// delete
		String q="delete from student where id=?";
		this.jdbcTemplate.update(q,studentId);
		return 0;
	}

//	public Student getStudent(int studentId) {
//		// selecting single student 
//		String q="select * from student where id=?";
//		RowMapper<Student>rowMapper=new RowMapperImpl();
//		Student s=this.jdbcTemplate.queryForObject(q,rowMapper,studentId);
//		return s;
//	}
	
	// if you don't want RowMapperImpl class Then you can create ENUMS Class
	public Student getStudent(int studentId) {
		// selecting single student 
		String q="select * from student where id=?";
		Student s=this.jdbcTemplate.queryForObject(q,new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCity(rs.getString(3));
				return s;
			}
		},studentId);
		return s;
	}

	public List<Student> getAllStudent() {
		// selecting multiple student
		String q="select * from student";
		List<Student> s=(List<Student>) this.jdbcTemplate.query(q,new RowMapperImpl());
		return s;
	}

	

}
