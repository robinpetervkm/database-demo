package com.vattathara.database.databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vattathara.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	//DataBase Connection // spring way
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//select * from Person ;
	public List<Person> findAll(){
		return jdbcTemplate.query(
				"select * from person", 
				 new BeanPropertyRowMapper<Person>(Person.class));//Row Mapper thing
		
	}
	
	//select * from Person where id = ? ;
	public Person findById(int id){
		return jdbcTemplate.queryForObject(
				"select * from person where id = ?",new Object[] {id}, 
				new BeanPropertyRowMapper<Person>(Person.class));//Row Mapper thing
		
	}
	
	//delete from Person where id = ? ;
	public int deleteById(int id){
		return jdbcTemplate.update(
				"detete * from person where id = ?",new Object[] {id});
	}
	//insert into Person (id,name,location,birth_date) values(?,?,?,?)  
	public int insert(Person person){
		return jdbcTemplate.update(
				" insert into Person ("
				+ " id,name,location,birth_date) values("
				+ " ?,?,?,?)",new Object[] {person.getId(),person.getName(),
						person.getLocation(),person.getDateBirth()});
	}
	//update Person set (name=?,location=?,birth_date=?) where id = ? )
	public int update(Person person){
		return jdbcTemplate.update(
				" update Person set ("
						+ " name=?,location=?,birth_date=?) "
						+ " where id = ?",new Object[] {person.getName(),
								person.getLocation(),
								new Timestamp (
										person.getDateBirth().getTime()),
								person.getId()});
	}
}
